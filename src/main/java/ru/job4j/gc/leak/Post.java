package ru.job4j.gc.leak;

import java.util.List;

public class Post {
    private int id;
    private String text;
    private List<Comment> comment;

    public Post(int id, String text, List<Comment> comment) {
        this.id = id;
        this.text = text;
        this.comment = comment;
    }

    public Post(String text, List<Comment> comment) {
        this.text = text;
        this.comment = comment;
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

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
