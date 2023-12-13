package com.example.demo.components;

import com.example.demo.model.UserStatusContainer;

import reactor.core.publisher.Mono;

public interface UserStatusService {
	Mono<UserStatusContainer> setOnline();
	Mono<UserStatusContainer> setOffline();
	
	Mono<UserStatusContainer> checkStatus();
	
	Mono<UserStatusContainer> setCustomOnline();
	Mono<UserStatusContainer> setCustomOffline();
}
