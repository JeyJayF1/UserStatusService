package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.components.UserStatusService;
import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserStatusControllerImpl implements UserStatusController {
	
	
	final private UserStatusService service;
	
	@GetMapping(
			path = "/status/online",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<UserStatusContainer> Online() {
		return service.Online();
	}
	
	@GetMapping(
			path = "/status/offline",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<UserStatusContainer> Offline() {
		return service.Offline();
	}
	
	@GetMapping(
			path = "/status/check",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<UserStatusContainer> checkStatus() {
		
		return service.checkStatus();
	}
	
	
	@PostMapping(
			path = "/status/setOffline",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<Object> setOffline(User user) {
		return service.setOffline(user);
	}


}
