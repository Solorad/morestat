package com.morenkov.ee.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author emorenkov
 */
@Configuration
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/", "/index**", "/login**", "/webjars/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//    }


//    /**
//     * This is only for test purpose, so it is not bad to show client secret on github.
//     *
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    public OAuth2ProtectedResourceDetails instagramResourceDetails() {
//        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//        details.setId("morestat");
//        details.setClientId("df5cc67d71e04b1b9a89ca9e1572a801");
//        details.setClientSecret("8da04f4072a54579ae4e334d5e865fa4");
//        details.setAccessTokenUri("https://api.instagram.com/oauth/authorize/");
//        details.setUserAuthorizationUri("http://localhost:8080/morestat/profile");
//
//        details.setScope(Arrays.asList("basic", "likes", "comments", "relationships", "public_content"));
//        return details;
//    }
//
//    @Bean
//    public OAuth2RestTemplate instagramRestTemplate(OAuth2ClientContext clientContext) {
//        return new OAuth2RestTemplate(instagramResourceDetails(), clientContext);
//    }
//
//    @Bean
//    public OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler() {
//        return new OAuth2AccessDeniedHandler();
//    }

}
