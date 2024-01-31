package com.example.demo.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			path = "/status/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<UserStatusContainer> checkStatus(@PathVariable UUID id) {
		
		return service.checkStatus(id);
	}
	
	
	@PostMapping(
			path = "/status/setOffline/{user}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<Object> setOffline(@PathVariable User user) {
		return service.setOffline(user);
	}
	
	@PostMapping(
			path = "/status/setOnline/{user}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@Override
	public Mono<Object> setOnline(@PathVariable User user) {
		return service.setOnline(user);
	}


}
