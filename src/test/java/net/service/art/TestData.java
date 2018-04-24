package net.service.art;

import net.service.art.model.Article;
import net.service.art.model.Comment;

import java.time.LocalDate;

/**
 * Created by Ivan.
 */
public class TestData {
    public Comment FIRST_TEST_COMMENT = new Comment(101, 100, "The first test comment", LocalDate.of(2018, 4, 9).atStartOfDay());
    public Comment SECOND_TEST_COMMENT = new Comment(102, 100, "The two test comment", LocalDate.of(2018, 4, 8).atStartOfDay());
    public Article FIRST_TEST_ARTICLE = new Article(101, "The first test", "Article1", LocalDate.of(2018, 4, 9).atStartOfDay());
    public Article SECOND_TEST_ARTICLE = new Article(101, "The two test", "Article2", LocalDate.of(2018, 4, 8).atStartOfDay());
    public Comment UPDATE_COMMENT = new Comment(101, 100, "Update test comment", LocalDate.of(2018, 4, 9).atStartOfDay());

    public void init() {
        FIRST_TEST_COMMENT.setId(100000);
        SECOND_TEST_COMMENT.setId(100001);
        FIRST_TEST_ARTICLE.setId(100000);
        SECOND_TEST_ARTICLE.setId(100001);
    }
}
