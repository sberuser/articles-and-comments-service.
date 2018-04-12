package net.service.art.service;

import net.service.art.model.Article;

import java.util.List;

/**
 * Created by Ivan.
 */
public interface ArticleService {
    public void saveArticle(Article article);

    public void updateArticle(Article article);

    public void removeArticle(int id);

    public Article delete(int userid, int id);

    public Article get(int userid, int id);

    public Article getArticleById(int id);

    public List<Article> listArticles();
}
