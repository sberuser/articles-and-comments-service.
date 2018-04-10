package net.service.art.controller;

import net.service.art.model.Article;
import net.service.art.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ivan.
 */
@Controller
public class ArticleController {
    private ArticleService service;

    @Autowired(required = true)
    @Qualifier(value = "artService")
    public void setService(ArticleService service) {
        this.service = service;
    }

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public String listArticles(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("listArticles", this.service.listArticles());

        return "articles";
    }

    @RequestMapping(value = "/articles/add", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute("article") Article article) {
        if(article.getId() == 0) {
            this.service.createArticle(article);
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

    @RequestMapping("/articledata/{id}")
    public String articleData(@PathVariable("id") int id, Model model){
        model.addAttribute("article", this.service.getArticleById(id));
        return "articledata";
    }
}
