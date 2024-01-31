package com.example.demo.security;

import io.r2dbc.spi.ConnectionFactories;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.relational.core.query.CriteriaDefinition;
import org.springframework.data.relational.core.query.Query;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;


import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Criteria.where;

public class CustonUserJWTConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {

    ConnectionFactory conn = ConnectionFactories.get("r2dbc:h2:mem:///ps_user");

    @Override
    public Mono<AbstractAuthenticationToken> convert(Jwt source) {
        var r2Template = new R2dbcEntityTemplate(conn);
        String email = source.getClaimAsString("email");

        CriteriaDefinition criteria = where("email").is(email);
        Query query = Query.query(criteria);

        Mono<User> fetchUser = r2Template.selectOne(query, User.class);

        System.out.println(fetchUser);
        User user = User.builder()
                .email(email)
                .nickname(String.valueOf(fetchUser.map(User::nickname)))
                .id(fetchUser.map(User::id).block())
                .build();

        return Mono.just(new AccountToken(source, user));
    }
}