package net.service.art.controller;

import net.service.art.model.Comment;
import net.service.art.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Ivan.
 */
@RestController
@RequestMapping
public class CommentController {

    private CommentService commentService;

    @Autowired
    @Qualifier(value = "commentService")
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Comment save(Comment comment) {
        if(comment.getId() == 0) {
            this.commentService.save(comment);
        } else {
            this.commentService.update(comment);
        }
        return comment;
    }

    @RequestMapping(value = "/comment/deleted/{id}/{userId}", method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment delete(@PathVariable(value = "id") int id,
                          @PathVariable(value = "userId") int userId) {
        return commentService.delete(id, userId);
    }

    @RequestMapping(value = "/comments/user/{userId}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAll(@PathVariable(value = "userId") int userId) {
        return commentService.getAll(userId);
    }
}
