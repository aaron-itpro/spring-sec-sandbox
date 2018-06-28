package com.us.itp.sandbox.springsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public final class UserRegistry implements UserDetailsService {

    @NonNull private final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    @Autowired
    public UserRegistry(@NonNull final UserDetails... users) {
        for (UserDetails user : users) {
            manager.createUser(user);
        }
    }

    @Override
    @NonNull public UserDetails loadUserByUsername(@NonNull final String username)
    throws UsernameNotFoundException {
        return manager.loadUserByUsername(username);
    }
}
