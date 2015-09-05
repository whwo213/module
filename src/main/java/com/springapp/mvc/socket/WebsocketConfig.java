package com.springapp.mvc.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by young on 2015-09-05.
 */
@Configuration
@EnableWebSocket
public class WebsocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Autowired
    private EchoHandler echoHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoHandler, "/echo");
    }
}
