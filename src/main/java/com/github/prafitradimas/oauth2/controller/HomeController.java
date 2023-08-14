package com.github.prafitradimas.oauth2.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    /**
     * @param principal
     **/
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String index(@AuthenticationPrincipal OAuth2User principal) {
        return "<h1>Welcome</h1><p>"+ principal.toString() +"</p>";
    }

}
