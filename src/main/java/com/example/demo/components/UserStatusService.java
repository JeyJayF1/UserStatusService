package com.example.demo.components;

import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;

import reactor.core.publisher.Mono;

public interface UserStatusService {
	Mono<UserStatusContainer> Online();
	
	Mono<UserStatusContainer> Offline();
	
	Mono<UserStatusContainer> checkStatus();
	
	Mono<Object> setOffline(User user);
	
}
