package com.example.demo.components;

import java.util.UUID;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.User;
import com.example.demo.model.UserStatusContainer;
import com.example.demo.repositories.UserNotFoundException;
import com.example.demo.repositories.UserRepository;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserStatusServiceImpl implements UserStatusService {


	private final UserRepository repo;
	private final ConnectionFactory conn;
	private WebClient webClient;
	
	@Override
	public Mono<UserStatusContainer> checkStatus() {
		User user1 = webClient.get()//.attribute("Authorization", "Bearer" + Jwt.getTokenValue())
				.uri("http://localhost:8080/getUser")
				.retrieve().bodyToMono(User.class)
				.block();
		
		var r2Template = new R2dbcEntityTemplate(conn);
		user1.setStatus(Online());
		
		r2Template.insert(user1);
		
		
		return user1.getStatus();
		}
	

	@Override
	public Mono<UserStatusContainer> Online() {
		var container = new UserStatusContainer();
		container.setUserStatusString("User is Online");
		
		return Mono.just(container);
	}

	@Override
	public Mono<UserStatusContainer> Offline() {
		var container = new UserStatusContainer();
		container.setUserStatusString("User is Offline");
		
		return Mono.just(container);
	}


	@Override
	public Mono<Object> setOffline(User user) {
		return repo.existsById(user.getId())
				.flatMap( res -> {
					if(res) {
						user.setStatus(Offline());
						return null;
					}
					return userNotFound(user.getId() );
				})
				;
	}
	
	private Mono<User> userNotFound(UUID id){
		return Mono.error(new UserNotFoundException(
				"User of id {" + id.toString() + "} not found" ));
	}
	
	

}
