package com.jwt.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

//only these three beans are required for  security with username and password saved in databasse
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().
                username("vaishnav")
                .password(passwordEncoder().encode("vaishnav"))
//                .roles("ADMIN").
                .build();

        UserDetails user1 = User.builder().
                username("vaish")
                .password(passwordEncoder().encode("vaish")).roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(user,user1);
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }



    @Autowired
    private  UserDetailsService userDetailsService;
    @Bean
    public DaoAuthenticationProvider authprovider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());    depricated
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }
}
