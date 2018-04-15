package net.service.art.service;

import net.service.art.dao.ArticleDao;
import net.service.art.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao repository;

    public void setRepository(ArticleDao repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void saveArticle(Article article) {
        this.repository.saveArticle(article);
    }

    @Override
    @Transactional
    public Article updateArticle(Article article) {
        return this.repository.updateArticle(article);
    }

    @Override
    @Transactional
    public Article removeArticle(int id) {
        return this.repository.removeArticle(id);
    }

    @Override
    @Transactional
    public Article getArticleById(int id) {
        return this.repository.getArticleById(id);
    }

    @Override
    @Transactional
    public Article delete(int userId, int id) {
        return this.repository.delete(userId, id);
    }

    @Override
    @Transactional
    public Article get(int userId, int id) {
        return this.repository.get(userId, id);
    }

    @Override
    @Transactional
    public List<Article> listArticles() {
        return this.repository.listArticles();
    }

    @Override
    @Transactional
    public List<Article> getAll(int userId) {
        return this.repository.getAll(userId);
    }
}
