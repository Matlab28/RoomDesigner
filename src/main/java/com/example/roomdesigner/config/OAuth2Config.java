package com.example.roomdesigner.config;//package com.example.youtubeavtostop.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientRepository;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
//import org.springframework.security.oauth2.client.web.inmemory.InMemoryOAuth2AuthorizedClientRepository;
//import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//@Configuration
//public class OAuth2Config {
//
//    @Bean
//    public OAuth2AuthorizedClientService oAuth2AuthorizedClientService(
//            ClientRegistrationRepository clientRegistrationRepository,
//            OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository) {
//        return new OAuth2AuthorizedClientService(clientRegistrationRepository, oAuth2AuthorizedClientRepository);
//    }
//
//    @Bean
//    public OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository() {
//        // You can customize this to use a persistent store (e.g., database) instead of memory
//        return new InMemoryOAuth2AuthorizedClientRepository();
//    }
//}
