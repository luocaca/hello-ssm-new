package com.hisen.entity;


/* 登山活动类 */
public class Mountaineering {


    private int id;
    private String imagesBanner;
    private String imagesMore;
    private String createDate;


    /* 活动名称 */
    private String title;


    private String desc;


    /* 报名列表 */
    private String userJoin;

    /* 活动领队 */
    private String leaderName;


    /* 活动优惠  */
    private String specialOffers;


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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
}
