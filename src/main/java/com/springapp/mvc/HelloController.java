package com.springapp.mvc;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	public static class MessageDTO {

		public Date date;
		public String content;
		public String id;

		public MessageDTO(String message) {
			this.date = Calendar.getInstance().getTime();
			this.content = message;

		}
	}

	@MessageMapping("/guestbook")
	@SendTo("/topic/entries")
	public MessageDTO guestbook(String message) {
        System.out.println("Received message: "+message);
		return new MessageDTO(message);
	}
}