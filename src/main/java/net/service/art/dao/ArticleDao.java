package net.service.art.dao;

import net.service.art.model.Article;

import java.util.List;

/**
 * Created by Ivan.
 */
public interface ArticleDao {
    public void saveArticle(Article article);

    public Article updateArticle(Article article);

    public Article removeArticle(int id);

    public Article delete(int userId, int id);

    public Article get(int userId, int id);

    public Article getArticleById(int id);

    public List<Article> listArticles();

    public List<Article> getAll(int userId);
}
