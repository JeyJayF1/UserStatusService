package com.example.demo.components;

import java.util.UUID;

import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;

import reactor.core.publisher.Mono;

public interface UserStatusService {
	Mono<UserStatusContainer> Online();
	
	Mono<UserStatusContainer> Offline();
	
	Mono<Object> setOffline(User user);
	
	Mono<Object> setOnline(User user);

	Mono<UserStatusContainer> checkStatus(UUID id);

	User getUser(UUID id);

	
}
