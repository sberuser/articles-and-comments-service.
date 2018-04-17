package net.service.art.controller;

import net.service.art.model.Article;
import net.service.art.service.ArticleService;
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
public class RestArticleController {
    private ArticleService service;

    @Autowired
    @Qualifier(value = "artService")
    public void setService(ArticleService service) {
        this.service = service;
    }

    @RequestMapping(value = "/articles", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> GetListArticles(){
        return service.listArticles();
    }

    @RequestMapping(value = "/article/{userId}", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Article save(@RequestBody Article article,
                                      @PathVariable("userId") Integer userId) {
        if(article.getId() == 0) {
            this.service.saveArticle(article);
        } else {
            this.service.updateArticle(article);
        }
        return article;
    }

    @RequestMapping(value = "/article/{id}/{userId}", method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Article delete(@PathVariable("id") Integer id,
                                        @PathVariable("userId") Integer userId) {
        return service.delete(userId, id);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Article getArticleData(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(value = "/articles/{userId}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> getAllArticlesByUserId(@PathVariable("userId") Integer userId) {
        return service.getAll(userId);
    }
}
