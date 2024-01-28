package com.example.demo.model;

import lombok.Data;
import reactor.core.publisher.Mono;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table("ps_user")
public class User {

    @Id
    private UUID id;

    @Column("nickname")
    private String nickname;

    @Column("email")
    private String email;
    
    @Column("status")
    private Mono<UserStatusContainer> status;

}
