package com.johnnghia.mvvmproject.models;

import java.util.Date;

public class Blog {
    private String id;
    private String detail;
    private String idAuthor;
    private int like;
    private int dislike;
    private int favorite;
    private Date createAt;
    private Date changedAt;
    private int view;
    private String tag;
    private String media = null; //se cap nhat sau


    public Blog(String id, String detail, String idAuthor, int like, int dislike, int favorite, Date createAt, Date changedAt, int view, String tag) {
        this.id = id;
        this.detail = detail;
        this.idAuthor = idAuthor;
        this.like = like;
        this.dislike = dislike;
        this.favorite = favorite;
        this.createAt = createAt;
        this.changedAt = changedAt;
        this.view = view;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
