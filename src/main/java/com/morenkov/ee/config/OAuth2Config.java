package com.morenkov.ee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.configuration.ClientDetailsServiceConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.*;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * @author emorenkov
 */
@Configuration
@EnableOAuth2Client
public class OAuth2Config {

    /**
     * This is only for test purpose, so it is not bad to show client secret on github.
     *
     * @return
     * @throws Exception
     */
    @Bean
    public OAuth2ProtectedResourceDetails instagramResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("morestat");
        details.setClientId("df5cc67d71e04b1b9a89ca9e1572a801");
        details.setClientSecret("8da04f4072a54579ae4e334d5e865fa4");
        details.setAccessTokenUri("https://api.instagram.com/oauth/authorize/");
        details.setUserAuthorizationUri("http://localhost:8080/morestat/profile");

        details.setScope(Arrays.asList("basic", "likes", "comments", "relationships", "public_content"));
        return details;
    }

    @Bean
    public OAuth2RestTemplate instagramRestTemplate(OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(instagramResourceDetails(), clientContext);
    }

    @Bean
    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
}
