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
import com.google.gson.JsonObject;
import com.hisen.entity.Moments;
import com.hisen.entity.Notify;

import java.util.HashMap;
import java.util.Map;

public class hellow {


    //2876f7e0f51c4153aadc603b661fedfa       33adafca5e1b4706b63df9b2903d5020
//5ea65acf72f09d1fa4664a00
    public static String APP_KEY = "5ea65acf72f09d1fa4664a00";
    public static String MASTER_SECRET = "cb2fe7bb39be10f2be500ab1";
    public static String ALERT = "HELL WORLD";
    public static String TITLE = "TITLE ";


    public static void main(String... args) {


        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_with_msg(json);

        PushPayload payload = buildPushObject_with_extra_aaaa(json);
//        PushPayload payload = buildPushObject_with_extra(json);
//      PushPayload payload = buildPushObject_with_extra();
//      PushPayload payload = buildPushObject_all_all_alert();


        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            System.out.println("Connection error, should retry later");

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            System.out.println("Should review the error, and fix the request");
            System.out.println("HTTP Status: " + e.getStatus());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Message: " + e.getErrorMessage());
        }


    }


    //快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
    public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll(ALERT);
    }


    //构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
    public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }

    //构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE。
    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(ALERT, TITLE, null))
                .build();
    }


    public static PushPayload buildPushObject_with_msg(String momentId) {

        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.all())
                .setMessage(Message.newBuilder().setMsgContent(momentId).addExtra("momentId", momentId).addExtra("bb", "bb").addExtra("cc", "cc").build())
                .build();

        System.out.println(payload.toJSON());
        return payload;
    }


    public static PushPayload buildPushObject_with_extra_aaaa(String momentId) {
        Notify notify = new Notify();
        notify.notyfyType = Notify.NotifyType.collect.key;
        notify.notyfyContent = "notyfyContent123456";

// //2876f7e0f51c4153aadc603b661fedfa       33adafca5e1b4706b63df9b2903d5020
        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.android_ios())
//                .setAudience(Audience.all())
//                .setAudience()2876f7e0f51c4153aadc603b661fedfa
                .setAudience(Audience.alias("2876f7e0f51c4153aadc603b661fedfa"))
                .setMessage(Message.newBuilder().setMsgContent(momentId).addExtra("momentId", momentId).addExtra("bb", "bb").addExtra("cc", "cc").build())
                .setNotification(
                        Notification
                                .newBuilder()
                                .setAlert("alert content")
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder().setTitle("有人给您点赞了^_^,点我查看哦~~~ ")
                                                .addExtra("notyfyType", Notify.NotifyType.collect.key)
                                                .addExtra("numberExtra", 1)
                                                .addExtra("momentId", momentId)
                                                .addExtra("momentsId", momentId)
                                                .addExtra("option", "update")
                                                .addExtra("tag", 0)
                                                .build())
                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtra("extra_key", "extra_value").build()).build()).build();

        System.out.println(payload.toJSON());

        return payload;

    }

    public static PushPayload buildPushObject_with_extra(String momentId) {
        JsonObject jsonExtra = new JsonObject();
        jsonExtra.addProperty("extra1", 1);
        jsonExtra.addProperty("extra2", false);
        Moments moments = new Moments();
        moments.id = "moments id";
        moments.replyCount = 10;

        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extra_1", "val1");
        extras.put("extra_2", "val2");

        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.all())
//                .setAudience(Audience.tag("tag1"))
                .setMessage(Message.newBuilder().setMsgContent(momentId).addExtra("momentId", "momentId").addExtra("bb", "bb").addExtra("cc", "cc").build())
                .setNotification(
                        Notification
                                .newBuilder()
                                .setAlert("alert content")
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder().setTitle("有人给您点赞了^_^,点我查看哦~~~ ")
                                                .addExtras(extras)
                                                .addExtra("booleanExtra", false)
                                                .addExtra("numberExtra", 1)
                                                .addExtra("jsonExtra", jsonExtra)
                                                .addExtra("momentId", momentId)
                                                .addExtra("tag", 0)
                                                .build())
                                .addPlatformNotification(IosNotification.newBuilder().incrBadge(1).addExtra("extra_key", "extra_value").build()).build()).build();

        System.out.println(payload.toJSON());
        return payload;
    }


    public static final String json = "955a53481d514a3eb424c7e74463f03a";

}
