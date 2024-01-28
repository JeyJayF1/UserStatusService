package com.example.demo.repositories;


import com.example.demo.model.User;

import reactor.core.publisher.Mono;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,UUID>{
	Mono<User> findById(UUID id);
}
