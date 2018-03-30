package com.hisen.common;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


/**
 * web 聊天室   聊天类  。保存所有session
 */
public class WebSocketUtils {


    private static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();


    public static String getOnlineList() {

        StringBuffer stringBuffer = new StringBuffer();
        sessionMap.forEach((a, b) -> {
            stringBuffer.append("\n" + a);
        });
        return stringBuffer.toString();
    }

    public static int getCount() {
        return sessionMap.size();
    }

    /**
     * 前缀
     */
//    private static final String PREFIX = "luocaca";
    private static final String PREFIX = "";


    public static List<Session> getOtherSession(String userId) {
        List<Session> resule = new ArrayList<>();
        Set<Map.Entry<String, Session>> set = sessionMap.entrySet();
        set.forEach(stringSessionEntry -> {
            if (!stringSessionEntry.getKey().equals(getKey(userId))) {
                resule.add(stringSessionEntry.getValue());
            } else {
                resule.add(stringSessionEntry.getValue());
            }
        });
        return resule;
    }

    public static Session get(String userId) {
        return sessionMap.get(getKey(userId));
    }

    public static void put(String userId, Session session) {
        System.out.println("添加一个 session 到列表  userId = " + userId);
        if ("游客".equals(userId)) {
            sessionMap.put(getKey(userId + sessionMap.size()), session);
        } else {
            if (!hasConnection(userId))
                sessionMap.put(getKey(userId), session);
        }
    }

    public static void remove(String userId) {
        System.out.println("移除一个 session 从列表  userId = " + userId);
        if (hasConnection(userId))
            sessionMap.remove(getKey(userId));
    }

    public static boolean hasConnection(String userId) {
        return sessionMap.containsKey(getKey(userId));
    }


    private static String getKey(String userId) {
        return PREFIX + "_" + userId;
    }

}
