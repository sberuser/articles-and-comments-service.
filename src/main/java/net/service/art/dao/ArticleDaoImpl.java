package net.service.art.dao;

import net.service.art.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ivan.
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveArticle(Article article) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(article);
    }

    @Override
    public Article updateArticle(Article article) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(article);
        return article;
    }

    @Override
    public Article removeArticle(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.load(Article.class, new Integer(id));

        if (article != null) {
            session.delete(article);
        }
        return article;
    }

    @Override
    public Article delete(int userId, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.createCriteria(Article.class)
                .add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("id", id))
                .list().stream()
                .findFirst()
                .orElse(null);
        if (article != null) {
            session.delete(article);
        }
        return article;
    }

    @Override
    public Article get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.createCriteria(Article.class)
                .add(Restrictions.eq("id", id))
                .list().stream()
                .findFirst()
                .orElse(null);
        return article;
    }

    @Override
    public Article getArticleById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Article article = (Article) session.get(Article.class, new Integer(id));
        return article;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> listArticles() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Article> articleList = session.createQuery("from Article").list();
        return articleList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> getAll(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Article> articles = session.createCriteria(Article.class)
                .add(Restrictions.eq("userId", userId))
                .list();
        return articles;
    }
}
