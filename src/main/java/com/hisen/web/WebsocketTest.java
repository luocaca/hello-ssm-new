package com.hisen.web;

import com.hisen.common.PushUtil;
import com.hisen.common.WebSocketUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试web socket 服务端
 */
@ServerEndpoint("/hello/{userId}")
public class WebsocketTest {

    public WebsocketTest() {
        log("WebSocketTest.......");
    }


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @OnOpen
    public void onopen(@PathParam("userId") String userId, Session session) {
        log("连接成功" + session.getId());
        WebSocketUtils.put(userId, session);
        try {
            session.getBasicRemote().sendText("登录成功+当前在线人数:" + WebSocketUtils.getCount() + "人 \n ----- " + "\n" + WebSocketUtils.getOnlineList() + "\n  --- \n");
        } catch (IOException e) {
            try {
                session.getBasicRemote().sendText("登录失败");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }


    @OnClose
    public void onclose(@PathParam("userId") String userId, Session session) {
        log("close.......");
        WebSocketUtils.remove(userId);
    }

    /**
     * 接收到客户端的信息
     *
     * @param msg
     */
    @OnMessage
//    public void message(Session session,boolean last,String msg){
    public void message(@PathParam("userId") String userId, Session session, String msg) {
        System.out.println("客户端说:" + msg);
        try {
            //
            System.out.println("通过服务器转发给 其他端 - >");

            //服务器转发消息成功
            System.out.println("发送：" + msg);
//            session.getBasicRemote().sendText(userId + " :\n    " + msg);
//            session.getBasicRemote().sendText("服务器正在转发消息^_^");
            WebSocketUtils.getOtherSession(userId).forEach(session1 -> {
                try {

                    if (session1.isOpen()) {
                        System.out.println("还有存在连接");
                        session1.getBasicRemote().sendText(userId + " :\n    " + msg);
                    }


                } catch (IOException e) {
                    WebSocketUtils.remove(userId);
                    System.out.println("移除失去连接的  session");

                    System.out.println("服务器转发消息失败！");
                    e.printStackTrace();
                }
            });


        } catch (Exception e) {
            System.out.println("服务器转发消息失败！");
            System.out.println("移除失去连接的  session");
            WebSocketUtils.remove(userId);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 错误监听（当没有关闭socket连接就关闭浏览器会异常）
     */
    @OnError
    public void error(Session session, Throwable error) {
        String id = session.getId();
        System.out.println("出错的session的id是" + id);
    }

    public void log(String msg) {
        System.out.println(msg);
        logger.debug(msg);
    }

}