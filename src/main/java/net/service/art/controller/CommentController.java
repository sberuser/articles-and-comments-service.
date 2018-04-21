package net.service.art.controller;

import net.service.art.model.Comment;
import net.service.art.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Comment save(@RequestBody Comment comment) {
        if(comment.getId() == 0) {
            this.commentService.save(comment);
        } else {
            this.commentService.update(comment);
        }
        return comment;
    }

    @RequestMapping(value = "/comment/deleted/{articleId}/{userId}", method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Comment delete(@PathVariable(value = "articleId") Integer articleId,
                                        @PathVariable(value = "userId") Integer userId) {
        return commentService.delete(articleId, userId);
    }

    @RequestMapping(value = "/comments/user/{articleId}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getAll(@PathVariable(value = "articleId") Integer articleId) {
        return commentService.getAll(articleId);
    }
}
