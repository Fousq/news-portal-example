package org.zhumagulova.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Date;

public class News {

    private long id;

    // Bad practice
    private long news_id;

    private Date date;

    @Size(min = 2, max = 100, message = "Title should be from 2 to 100 characters")
    private String title;

    @Size(min = 10, max = 600, message = "Brief content should be from 10 to 600 characters")
    private String brief;

    @Size(min = 20, max = 5000, message = "Content should be from 20 to 3000 characters")
    private String content;

    @Min(value = 1, message = "Language id should be not less than 1")
    private long language;

    public News(long id, long news_id, Date date, String title, String brief, String content, long language) {
        this.id = id;
        this.news_id = news_id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.language = language;
        this.date = date;
    }

    public News(Date date,String title, String brief, String content, int language) {
        this.date=date;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.language = language;
    }

    public News() {}

    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getLanguage() {
        return language;
    }

    public void setLanguage(long language) {
        this.language = language;
    }
}
