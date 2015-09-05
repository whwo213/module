package com.springapp.mvc.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by young on 2015-09-05.
 */
@Component
public class EchoHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        TextMessage echoMessage = new TextMessage("ECHO :" + message.getPayload());
        session.sendMessage(echoMessage);
    }
}