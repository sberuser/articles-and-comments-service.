package net.service.art.dao;

import net.service.art.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ivan.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Comment save(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(comment);
        return comment;
    }

    @Override
    public Comment delete(int id, int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        Comment comment = (Comment) session.createCriteria(Comment.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("userId", userId))
                .list().stream()
                .findFirst()
                .orElse(null);
        if (comment != null) {
            session.delete(comment);
        }
        return comment;
    }

    @Override
    public List<Comment> getAll(int articleId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Comment> comments = session.createCriteria(Comment.class)
                .add(Restrictions.eq("articleId", articleId))
                .list();
        return comments;
    }
}
