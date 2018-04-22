package net.service.art.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import net.service.art.DateUtil;
import net.service.art.ParseDeserializer;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Ivan.
 */
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "articleId")
    private int articleId;

    @Column(name = "text")
    private String text;

    @Column(name = "dateTime")
    @Convert(converter = DateUtil.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
    private LocalDateTime dateTime;

    public Comment() {
    }

    public Comment(int userId, int articleId, String text, LocalDateTime dateTime) {
        this.userId = userId;
        this.articleId = articleId;
        this.text = text;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Comment ID: " + id + "/n" +
                "Article ID: " + articleId + "/n" +
                "TEXT: " + text;
    }
}
