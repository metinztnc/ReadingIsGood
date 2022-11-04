package com.readingIsGood.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //swagger endpoints
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                //book endpoints
                .antMatchers("/book/**").permitAll()
                //customer endpoints
                .antMatchers("/customer/**").permitAll()
                //order endpoints
                .antMatchers("/order/**").permitAll()
                //stock endpoints
                .antMatchers("/stock/**").permitAll();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
