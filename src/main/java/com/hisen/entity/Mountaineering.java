package com.hisen.entity;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;

/* 登山活动类 */
public class Mountaineering implements Serializable {


    private int id;
    private String imagesBanner;
    private String imagesMore;

    private List<UrlBean> listImagesBanner;

    private List<UrlBean> listImagesMore;


    private Date createDate;


    private int price;

    /* 活动名称 */
    private String title;


    /* 介绍 */
    private String desc;


    /* 报名列表 */
    private String userJoin;

    /* 活动领队 */
    private String leaderName;


    /* 上车地点 */
    private String loaction;

    /*  线路特色 */
    private String lineFeature;

    /* 风景指数 */
    private int star;


    /* 活动优惠  */
    private String specialOffers;

    /* 结束日期 */
    private String closeDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagesBanner() {
        return imagesBanner;
    }

    public void setImagesBanner(String imagesBanner) {
        this.imagesBanner = imagesBanner;
    }

    public String getImagesMore() {
        return imagesMore;
    }

    public void setImagesMore(String imagesMore) {
        this.imagesMore = imagesMore;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUserJoin() {
        return userJoin;
    }

    public void setUserJoin(String userJoin) {
        this.userJoin = userJoin;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getSpecialOffers() {
        return specialOffers;
    }

    public void setSpecialOffers(String specialOffers) {
        this.specialOffers = specialOffers;
    }


    public static void convertJsonToList(Mountaineering mountaineering) {


        Gson gson = new Gson();

        Type type = new TypeToken<List<UrlBean>>() {
        }.getType();


        mountaineering.listImagesBanner = gson.fromJson(mountaineering.imagesBanner, type);
        mountaineering.listImagesMore = gson.fromJson(mountaineering.imagesMore, type);

        mountaineering.imagesMore = null;
        mountaineering.imagesBanner = null;

    }

    public List<UrlBean> getListImagesBanner() {
        return listImagesBanner;
    }

    public void setListImagesBanner(List<UrlBean> listImagesBanner) {
        this.listImagesBanner = listImagesBanner;
    }

    public List<UrlBean> getListImagesMore() {
        return listImagesMore;
    }

    public void setListImagesMore(List<UrlBean> listImagesMore) {
        this.listImagesMore = listImagesMore;
    }

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public String getLineFeature() {
        return lineFeature;
    }

    public void setLineFeature(String lineFeature) {
        this.lineFeature = lineFeature;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }


    public static class UrlBean {
        public String url = "";
    }
}
