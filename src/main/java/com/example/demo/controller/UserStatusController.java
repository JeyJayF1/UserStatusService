package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;

import reactor.core.publisher.Mono;

public interface UserStatusController {
	Mono<UserStatusContainer> Online();
	Mono<UserStatusContainer> Offline();
	
	Mono<UserStatusContainer> checkStatus();
	Mono<Object> setOffline(User user);
	
}
