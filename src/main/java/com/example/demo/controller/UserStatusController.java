package com.example.demo.controller;

import java.util.UUID;

import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;

import reactor.core.publisher.Mono;

public interface UserStatusController {
	
	
	Mono<UserStatusContainer> checkStatus(UUID id);

	Mono<Object> setOnline(User user);
	
	Mono<Object> setOffline(User user);
	
}
