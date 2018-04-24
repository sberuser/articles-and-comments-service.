package net.service.art.service;

import net.service.art.TestData;
import net.service.art.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ivan.
 */
@ContextConfiguration({"classpath:context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentServiceImplTest {
    public static Comment UPDATE_COMMENT;
    public static Comment SECOND_COMMENT;

    TestData testData = new TestData();

    @Autowired
    private CommentService commentService;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        testData.init();

        UPDATE_COMMENT = testData.UPDATE_COMMENT;
        SECOND_COMMENT = testData.SECOND_TEST_COMMENT;

        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(), dataSource);
    }

    @Test
    public void getAllTest() {
        List<Comment> comments;

        comments = commentService.getAll(SECOND_COMMENT.getArticleId());

        assertEquals(2, comments.size());
    }

    @Test
    public void deleteTest() {
        Comment comment;

        comment = commentService.delete(SECOND_COMMENT.getArticleId(), SECOND_COMMENT.getUserId());

        assertEquals(SECOND_COMMENT.getArticleId(), comment.getArticleId());
    }
}