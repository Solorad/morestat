package com.morenkov.ee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author emorenkov
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
}
