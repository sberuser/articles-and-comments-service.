package net.service.art.service;

import net.service.art.model.Article;

import java.util.List;

/**
 * Created by Ivan.
 */
public interface ArticleService {
    public void createArticle(Article article);

    public void updateArticle(Article article);

    public void removeArticle(int id);

    public Article getArticleById(int id);

    public List<Article> listArticles();
}
