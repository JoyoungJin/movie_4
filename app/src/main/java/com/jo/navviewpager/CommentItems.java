package com.jo.navviewpager;

import java.io.Serializable;

public class CommentItems implements Serializable{
    public String id;
    public float rating;
    public String Comment;
    public int redId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }

    public CommentItems(String id, float rating, String comment, int redId) {
        this.id = id;
        this.rating = rating;
        Comment = comment;
        this.redId = redId;
    }
}