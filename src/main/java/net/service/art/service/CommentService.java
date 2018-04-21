package net.service.art.service;

import net.service.art.model.Comment;

import java.util.List;

/**
 * Created by Ivan.
 */
public interface CommentService {
    Comment save(Comment comment);

    Comment update(Comment comment);

    Comment delete(int articleId, int userId);

    List<Comment> getAll(int id);
}
