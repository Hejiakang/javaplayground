package com.example.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * spring boot中使用websocket的两个前置条件：
 * 1，引入spring-boot-starter-websocket依赖包
 * 2，写此配置此类
 * @author HaoKangKang healthhealthgood@gmail.com 2020-09-10 17:37
 **/
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
