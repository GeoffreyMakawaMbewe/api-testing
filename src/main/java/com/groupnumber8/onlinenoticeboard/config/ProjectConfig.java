package com.groupnumber8.onlinenoticeboard.config;

import com.groupnumber8.onlinenoticeboard.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {


    private final StudentService studentService;

    public ProjectConfig(StudentService studentService) {
        this.studentService = studentService;
    }

    @Bean
   public PasswordEncoder passwordEncoder(){
       return NoOpPasswordEncoder.getInstance();
   }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(studentService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/post").authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }
}
