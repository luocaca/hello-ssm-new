package com.hisen.web;


import org.springframework.context.annotation.Configuration;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Set;

@Configuration
public class ApplicationConfig implements ServerApplicationConfig {

    //扫描注解
    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
        System.out.println("scan WebSocket  afasdfa" + scan.size());
        //返回（起到过滤的作用，可以在返回前把里面部分类进行过滤）
        return scan;
    }


    //实现接口
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(
            Set<Class<? extends Endpoint>> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}