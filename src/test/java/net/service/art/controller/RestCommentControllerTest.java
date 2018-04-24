package net.service.art.controller;

import net.service.art.TestData;
import net.service.art.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Ivan.
 */
@ContextConfiguration({"classpath:context.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RestCommentControllerTest {
    public static Comment FIRST_COMMENT;
    public static Comment SECOND_COMMENT;
    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    TestData testData = new TestData();

    private MockMvc mock;

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {

        testData.init();

        FIRST_COMMENT = testData.FIRST_TEST_COMMENT;
        SECOND_COMMENT = testData.SECOND_TEST_COMMENT;

        MockitoAnnotations.initMocks(this);
        mock = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(CHARACTER_ENCODING_FILTER)
                .build();

        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(), dataSource);
    }

    @Test
    public void getAllTest() throws Exception {
        mock.perform(get("/comments/user/{articleId}", FIRST_COMMENT.getArticleId()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].articleId", is(FIRST_COMMENT.getArticleId())))
                .andExpect(jsonPath("$[0].text", is(FIRST_COMMENT.getText())))
                .andExpect(jsonPath("$[0].userId", is(FIRST_COMMENT.getUserId())))
                .andExpect(jsonPath("$[1].articleId", is(SECOND_COMMENT.getArticleId())))
                .andExpect(jsonPath("$[1].text", is(SECOND_COMMENT.getText())))
                .andExpect(jsonPath("$[1].userId", is(SECOND_COMMENT.getUserId())));
    }

    @Test
    public void deleteTest() throws Exception {
        mock.perform(MockMvcRequestBuilders
                .delete("/comment/deleted/{articleId}/{userId}", FIRST_COMMENT.getArticleId(), FIRST_COMMENT.getUserId()))
                .andExpect(status().isOk());
    }


}