package com.example.demo.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StatusWebSocketHandler implements WebSocketHandler {

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		Flux<WebSocketMessage> webSocketMessageFlux = session.receive()
				.map(WebSocketMessage::getPayloadAsText)
				.map(String::toUpperCase)
				.map(session::textMessage);

		return session.send(webSocketMessageFlux);
	}
}
