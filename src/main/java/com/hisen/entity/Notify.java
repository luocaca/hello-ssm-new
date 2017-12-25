package com.hisen.entity;

import java.io.Serializable;

public class Notify implements Serializable {


    public String notyfyType;

    public String notyfyJson;

    public String notyfyContent;


    public static enum NotifyType {

        /**
         * 评论
         */
        updata("supply", "评论"),

        /**
         * 回复
         */
        purchase("purchase", "回复"),

        /**
         * 点赞
         */
        collect("collect", "点赞"),

        /**
         * 消息通知
         */
        reciver("", "消息通知");

       public   String key, value;

        NotifyType(String enumValue, String enumText) {
            this.key = enumValue;
            this.value = enumText;
        }
    }


}


