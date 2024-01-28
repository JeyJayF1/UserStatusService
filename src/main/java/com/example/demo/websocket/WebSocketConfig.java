package com.example.demo.websocket;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebSocketConfig {

	@Bean
	HandlerMapping handlerMapping(WebSocketHandler wsh) {
		log.debug("Configuration Web Socket");
		return new SimpleUrlHandlerMapping() {
			{
				setUrlMap(Collections.singletonMap("/ws/status", wsh));
			}
		};
	}

	@Bean
	WebSocketHandler webSocketHandler() {
		return new StatusWebSocketHandler();
	}

}
