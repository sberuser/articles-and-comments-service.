package net.service.art.helpcontrol;

import net.service.art.model.Article;
import net.service.art.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivan.
 */
@RestController
@RequestMapping
public class ArticleController {
    private ArticleService service;

    @Autowired(required = true)
    @Qualifier(value = "artService")
    public void setService(ArticleService service) {
        this.service = service;
    }

    //---> JSON
    @RequestMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> listArticles(){
        return service.listArticles();
    }

    @RequestMapping(value = "/articles/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("article") Article article) {
        if(article.getId() == 0) {
            this.service.saveArticle(article);
        } else {
            this.service.updateArticle(article);
        }
        return "redirect:/articles";
    }

    @RequestMapping("/remove/{id}")
    public String removeArticle(@PathVariable("id") int id) {
        this.service.removeArticle(id);
        return "redirect:/articles";
    }

    @RequestMapping("/edit/{id}")
    public String editArticle(@PathVariable("id") int id, Model model){
        model.addAttribute("article", this.service.getArticleById(id));
        model.addAttribute("listArticles", this.service.listArticles());
        return "articles";
    }
    
    
    //---->-JSON-format
    @RequestMapping(value = "/article/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Article articleData(@PathVariable("id") int id){
        return service.getArticleById(id);
    }

    
    @RequestMapping(value = "/article/deleted/{userId}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Article delete(@PathVariable("userId") int userId, @PathVariable("id") int id) {
        return service.delete(userId, id);
    }

    @RequestMapping(value = "/article/get/{userId}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Article get(@PathVariable("userId") int userId, @PathVariable("id") int id) {
        return service.get(userId, id);
    }
}
