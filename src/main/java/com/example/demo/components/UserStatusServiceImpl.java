package com.example.demo.components;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserStatusContainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserStatusServiceImpl implements UserStatusService {

	@Override
	public Mono<UserStatusContainer> setOnline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<UserStatusContainer> setOffline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<UserStatusContainer> checkStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<UserStatusContainer> setCustomOnline() {
		var container = new UserStatusContainer();
		container.setUserStatusString("Online");
		
		return Mono.just(container);
	}

	@Override
	public Mono<UserStatusContainer> setCustomOffline() {
		var container = new UserStatusContainer();
		container.setUserStatusString("Offline");
		
		return Mono.just(container);
	}

}
