package net.service.art.controller;

import net.service.art.TestData;
import net.service.art.model.Article;
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
import static org.springframework.orm.jpa.vendor.Database.H2;
import static org.springframework.orm.jpa.vendor.Database.SQL_SERVER;
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
public class RestArticleControllerTest {
    public static Article FIRST_ARTICLE;
    public static Article SECOND_ARTICLE;
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
        FIRST_ARTICLE = testData.FIRST_TEST_ARTICLE;
        SECOND_ARTICLE = testData.SECOND_TEST_ARTICLE;

        MockitoAnnotations.initMocks(this);
        mock = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .addFilters(CHARACTER_ENCODING_FILTER)
                .build();


        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(), dataSource);
    }

    @Test
    public void getListArticlesTest() throws Exception {
        mock.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getAllArticlesByUserIdTest() throws Exception {
        mock.perform(get("/articles/{userId}", FIRST_ARTICLE.getUserId()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].text", is(FIRST_ARTICLE.getText())))
                .andExpect(jsonPath("$[0].userId", is(FIRST_ARTICLE.getUserId())))
                .andExpect(jsonPath("$[1].text", is(SECOND_ARTICLE.getText())))
                .andExpect(jsonPath("$[1].userId", is(SECOND_ARTICLE.getUserId())));
    }

    @Test
    public void deleteFirstTest() throws Exception {
        mock.perform(MockMvcRequestBuilders
                .delete("/article/{id}/{userId}", FIRST_ARTICLE.getId(), FIRST_ARTICLE.getUserId()))
                .andExpect(status().isOk());
    }
}