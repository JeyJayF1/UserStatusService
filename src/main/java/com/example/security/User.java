package com.example.security;

import java.util.UUID;
import lombok.Builder;


@Builder
public record User(
        String nickname,
        UUID id,
        String email
) {

}