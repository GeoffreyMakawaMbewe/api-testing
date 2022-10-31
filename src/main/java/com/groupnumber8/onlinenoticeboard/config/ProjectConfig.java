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
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public ProjectConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(this.userService);
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
         auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                 .cors()
                 .and()
                 .csrf()
                 .disable()
                 .authorizeRequests()
                 .antMatchers("/hello").hasAnyAuthority("STUDENT","ADMIN")
                 .antMatchers("/users").hasAnyAuthority("ADMIN")
                 .antMatchers("/logged").hasAnyAuthority(" ADMIN")
                 .antMatchers("/register").hasAnyAuthority("STUDENT","ADMIN")
                 .mvcMatchers(HttpMethod.POST,"/post").permitAll()
                 .antMatchers(HttpMethod.GET,"/all").authenticated()
                 .and()
                 .httpBasic();
    }
}