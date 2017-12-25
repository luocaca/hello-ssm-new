package com.hisen.common;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.hisen.entity.Notify;

public class PushUtil {

//    java.lang.NoClassDefFoundError: cn/jpush/api/push/model/notification/PlatformNotification
//    public static String APP_KEY = "27b97eb500b6ac59f8de2a97";
//    public static String MASTER_SECRET = "e26a442d2e0925a95345d9d9";


    public static String APP_KEY = "5ea65acf72f09d1fa4664a00";
    public static String MASTER_SECRET = "cb2fe7bb39be10f2be500ab1";
    public static String ALERT = "HELL WORLD";
    public static String TITLE = "TITLE ";
    public static final String json = "955a53481d514a3eb424c7e74463f03a";

    public static void sendPush(String pushId) {

        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
//        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        PushPayload payload = buildPushObject_with_extra_aaaa(pushId);


        // 请求结束后，调用 NettyHttpClient 中的 close 方法，否则进程不会退出。

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
            jpushClient.close();

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            System.out.println("Connection error, should retry later");

        } catch (APIRequestException e) {
            System.out.println("Should review the error, and fix the request");
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }
    }


    public static PushPayload buildPushObject_with_extra_aaaa(String momentId) {
        Notify notify = new Notify();
        notify.notyfyType = Notify.NotifyType.collect.key;
        notify.notyfyContent = "notyfyContent123456";
        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.android_ios())
//               .setAudience(Audience.all())
//              .setAudience(Audience.tag("tag1"))
                .setAudience(Audience.alias("2876f7e0f51c4153aadc603b661fedfa"))
                .setMessage(Message.newBuilder().setMsgContent(momentId)
                        .addExtra("momentId", momentId)
                        .addExtra("bb", "bb")
                        .addExtra("cc", "cc").build())
                .setNotification(
                        Notification
                                .newBuilder()
                                .setAlert("有人给您评论了，点击查看o ^_^")
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .setTitle("通知")
                                                .addExtra("messageType", "moments")
                                                .addExtra("momentId", momentId)
                                                .addExtra("momentsId", momentId)
                                                .addExtra("option", "add")
                                                .addExtra("sourceId", "459c3b5a1c4b4ebfba88fe9272c73243")
                                                .addExtra("type", "reply")
                                                .build())
                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtra("extra_key", "extra_value").build()).build()).build();

        System.out.println(payload.toJSON());

        return payload;

    }


//    public static PushPayload buildPushObject_with_extra_aaaa(String momentId) {
//        Notify notify = new Notify();
//        notify.notyfyType = Notify.NotifyType.collect.key;
//        notify.notyfyContent = "notyfyContent123456";
//        PushPayload payload = PushPayload
//                .newBuilder()
//                .setPlatform(Platform.android_ios())
////               .setAudience(Audience.all())
////              .setAudience(Audience.tag("tag1"))
//                .setAudience(Audience.alias("2876f7e0f51c4153aadc603b661fedfa"))
//                .setMessage(Message.newBuilder().setMsgContent(momentId).addExtra("momentId", momentId).addExtra("bb", "bb").addExtra("cc", "cc").build())
//                .setNotification(
//                        Notification
//                                .newBuilder()
//                                .setAlert("alert content")
//                                .addPlatformNotification(
//                                        AndroidNotification.newBuilder().setTitle("有人给您点赞了^_^,点我查看哦~~~ ")
//                                                .addExtra("notyfyType", Notify.NotifyType.collect.key)
//                                                .addExtra("numberExtra", 1)
//                                                .addExtra("momentId", momentId)
//                                                .addExtra("tag", 0)
//
//                                                .build())
//                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtra("extra_key", "extra_value").build()).build()).build();
//
//        System.out.println(payload.toJSON());
//
//        return payload;
//
//    }


}
