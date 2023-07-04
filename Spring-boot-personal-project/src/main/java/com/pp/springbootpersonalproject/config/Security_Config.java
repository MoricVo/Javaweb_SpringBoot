package com.pp.springbootpersonalproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class Security_Config {
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource)
    {
        UserDetails user= User.builder()
                .username("user11")
                .password("$2a$10$mWqyQchvVEZLY6m2PHjqk.9CjjFIom1zL3l/dMJ43x0tlqhUxkpmK")
                .roles("USER")
                .build();
        UserDetails admin= User.builder()
                .username("admin11")
                .password("$2a$10$mWqyQchvVEZLY6m2PHjqk.9CjjFIom1zL3l/dMJ43x0tlqhUxkpmK")
                .roles("USER","ADMIN")
                .build();
        JdbcUserDetailsManager users =new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
