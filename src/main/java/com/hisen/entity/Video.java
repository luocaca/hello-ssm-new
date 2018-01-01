package com.hisen.entity;

public class Video {
    private int id ;
    private String imageurl;
    private String url;
    private int type;
    private String createTime;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", imageurl='" + imageurl + '\'' +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", createTime='" + createTime + '\'' +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
