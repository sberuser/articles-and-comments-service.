package net.service.art.service;

import net.service.art.dao.CommentDao;
import net.service.art.model.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ivan.
 */
public class CommentServiceImpl implements CommentService {

    private CommentDao repository;

    public void setRepository(CommentDao repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Comment save(Comment comment) {
        return this.repository.save(comment);
    }

    @Override
    @Transactional
    public Comment update(Comment comment) {
        return this.repository.update(comment);
    }

    @Override
    @Transactional
    public Comment delete(int articleId, int userId) {
        return this.repository.delete(articleId, userId);
    }

    @Override
    @Transactional
    public List<Comment> getAll(int id) {
        return this.repository.getAll(id);
    }
}
