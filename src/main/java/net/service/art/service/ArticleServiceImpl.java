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
    public void updateArticle(Article article) {
        this.repository.updateArticle(article);
    }

    @Override
    @Transactional
    public void removeArticle(int id) {
        this.repository.removeArticle(id);
    }

    @Override
    @Transactional
    public Article getArticleById(int id) {
        return this.repository.getArticleById(id);
    }

    @Override
    @Transactional
    public Article delete(int userid, int id) {
        return this.repository.delete(userid, id);
    }

    @Override
    @Transactional
    public Article get(int userid, int id) {
        return this.repository.get(userid, id);
    }

    @Override
    @Transactional
    public List<Article> listArticles() {
        return this.repository.listArticles();
    }
}
