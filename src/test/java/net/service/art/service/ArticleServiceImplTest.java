package net.service.art.service;

import net.service.art.TestData;
import net.service.art.model.Article;
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
public class ArticleServiceImplTest {
    public static Article FIRST_ARTICLE;
    public static Article SECOND_ARTICLE;

    TestData testData = new TestData();

    @Autowired
    private ArticleService artService;

    @Autowired
    private DataSource dataSource;

    @Before
    public void init() {
        testData.init();

        FIRST_ARTICLE = testData.FIRST_TEST_ARTICLE;
        SECOND_ARTICLE = testData.SECOND_TEST_ARTICLE;

        DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(), dataSource);
    }

    @Test
    public void getAllTest() {
        List<Article> articles;

        articles = artService.getAll(FIRST_ARTICLE.getUserId());

        assertEquals(2, articles.size());
    }

    @Test
    public void getArticleByIdTest() {
        Article article;
        article = artService.getArticleById(FIRST_ARTICLE.getId());

        assertEquals(FIRST_ARTICLE.getUserId(), article.getUserId());
        assertEquals(FIRST_ARTICLE.getName(), article.getName());
        assertEquals(FIRST_ARTICLE.getText(), article.getText());
    }

    @Test
    public void deleteTest() {
        Article article;

        article = artService.delete(FIRST_ARTICLE.getUserId(), FIRST_ARTICLE.getId());

        assertEquals(FIRST_ARTICLE.getUserId(), article.getUserId());
        assertEquals(FIRST_ARTICLE.getName(), article.getName());
        assertEquals(FIRST_ARTICLE.getText(), article.getText());
    }
}