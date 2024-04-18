package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC ... no more hardcoded users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Below Code written is for set custom tables means different from default table schemas like users and authorities

        //define query to retrieve a user by userName
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        //define query to retrieve authorities/roles by userName
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        //use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        //Disable Cross Site Request Forgery
        //in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails sweta = User.builder()
                .username("sweta")
                .password("{noop}test123") //noop means plain text
                .roles("EMPLOYEE")
                .build();

        UserDetails sneha = User.builder()
                .username("sneha")
                .password("{noop}test123") //noop means plain text
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails sagar = User.builder()
                .username("sagar")
                .password("{noop}test123") //noop means plain text
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(sweta, sneha, sagar);
    }

 */
}
