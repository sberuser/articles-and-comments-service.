package net.service.art.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import net.service.art.DateUtil;
import net.service.art.ParseDeserializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ivan.
 */
@Entity
@Table(name = "articles")
public class Article implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "text")
    private String text;

    @Column(name = "name")
    private String name;

    @Column(name = "dateTime", updatable = false)
    @Convert(converter = DateUtil.class)
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
    private LocalDateTime dateTime;


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Article name: " + name + "/n" +
                "Article ID: " + id;
    }
}
