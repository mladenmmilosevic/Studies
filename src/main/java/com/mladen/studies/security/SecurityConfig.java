package com.mladen.studies.security;

import com.mladen.studies.entities.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsService = userDetailsServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/student", "/student/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.GET, "/predmet", "/predmet/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.GET, "/profesor", "/profesor/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.POST, "/student", "/student/**").hasRole(Role.ADMIN.toString())
                .antMatchers(HttpMethod.POST, "/predmet", "/predmet/**").hasRole(Role.ADMIN.toString())
                .antMatchers(HttpMethod.POST, "/profesor", "/profesor/**").hasRole(Role.ADMIN.toString())
                .antMatchers(HttpMethod.PUT, "/student/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/profesor/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.PUT, "/predmet/**").hasAnyRole(Role.ADMIN.toString(), Role.USER.toString())
                .antMatchers(HttpMethod.DELETE, "/student/**").hasRole(Role.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/profesor/**").hasRole(Role.ADMIN.toString())
                .antMatchers(HttpMethod.DELETE, "/predmet/**").hasRole(Role.ADMIN.toString())
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}