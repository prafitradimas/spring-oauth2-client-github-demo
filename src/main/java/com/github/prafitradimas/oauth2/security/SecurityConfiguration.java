package com.github.prafitradimas.oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth -> oauth.userInfoEndpoint(userInfo ->
                        userInfo.userService(oauth2LoginHandler())
                    )
                )
                .authorizeHttpRequests(customizer ->
                        customizer.anyRequest().authenticated()
                )
                .build();
    }

    private OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2LoginHandler() {
        return oauth2UserRequest -> {
            // using default oauth2 user service or
            // use your custom OAuth2UserService implementation
            // to extract user info
            var oauth2UserService = new DefaultOAuth2UserService();
            OAuth2User oAuth2User = oauth2UserService.loadUser(oauth2UserRequest);

            return oAuth2User;
        };
    }

}
