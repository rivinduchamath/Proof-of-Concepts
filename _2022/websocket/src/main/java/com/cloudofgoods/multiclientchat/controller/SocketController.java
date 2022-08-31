package com.cloudofgoods.multiclientchat.controller;


import com.cloudofgoods.multiclientchat.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/java")
    public Message register(@Payload Message chatMessage) {
        //headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

/*	@MessageMapping("/send")
	@SendTo("/topic")
	public Message sendMessage(@RequestBody Message chatMessage) {
		return chatMessage;
	}*/

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/java")
    public Message addUser(@Payload Message webSocketChatMessage,
                           SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", webSocketChatMessage.getSender());
        return webSocketChatMessage;
    }
}
