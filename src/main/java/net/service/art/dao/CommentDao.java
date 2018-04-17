package net.service.art.dao;

import net.service.art.model.Comment;

import java.util.List;

/**
 * Created by Ivan.
 */
public interface CommentDao {
    Comment save(Comment comment);

    Comment delete(int id, int userId);

    Comment update(Comment comment);

    List<Comment> getAll(int userId);
}
