package com.us.itp.sandbox.springsec.config;

import static com.us.itp.sandbox.springsec.util.UserUtil.createUser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class UserConfig {
    @NonNull @Bean public UserDetails primaryUser() { return createUser("user", "swordfish"); }
}
