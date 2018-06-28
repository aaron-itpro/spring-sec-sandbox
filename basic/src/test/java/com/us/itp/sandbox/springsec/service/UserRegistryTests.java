package com.us.itp.sandbox.springsec.service;

import static com.us.itp.sandbox.springsec.util.UserUtil.createUser;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public final class UserRegistryTests {

    private final UserDetails user = createUser("user", "albacore");
    private final UserRegistry registry = new UserRegistry(user);

    @Test
    public void knownUserIsRemembered() {
        assertEquals(user, registry.loadUserByUsername(user.getUsername()));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void unknownUserIsNotFound() {
        registry.loadUserByUsername("not" + user.getUsername());
    }
}
