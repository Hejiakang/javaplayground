package com.example.demo.websocket;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * 本类中websocket 的ServerEndpoint和onOpen等注解及其相关功能由javax提供，可以在web容器环境使用
 * 如果在spring boot中使用，需要用@Component注解，目的是交由spring管理
 * 注意：本类的对象不是单例的，每建立一个websocket连接就会创建一个新的对象
 * @author HaoKangKang healthhealthgood@gmail.com 2020-09-10 16:43
 **/
@ServerEndpoint(value="/locator")
@Component
public class LocatorEndpoint {
    @OnOpen
    public void onOpen(Session session) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final String message = "the number is " + i;
            session.getBasicRemote().sendText(this.hashCode() + ":" + message);
            System.out.println("已经发送：" + message);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("已经断开");
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("出现错误");
    }
}