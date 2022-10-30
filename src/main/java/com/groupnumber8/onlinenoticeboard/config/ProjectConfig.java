package com.groupnumber8.onlinenoticeboard.config;

import com.groupnumber8.onlinenoticeboard.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public ProjectConfig(UserService userService) {
        this.userService = userService;
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userService);
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
         auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests()
                 .antMatchers("/hello").authenticated()
                 .antMatchers("/users").authenticated()
                 .antMatchers("/logged").authenticated()
                 .antMatchers(HttpMethod.GET,"/all").authenticated()
                 .antMatchers("/post").authenticated()
                 .and()
                 .httpBasic();
    }
}