package com.us.itp.sandbox.springsec.util;

import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public final class UserUtil {

    private UserUtil() {
        throw new UnsupportedOperationException(
            "This class is a static utility class and cannot be instantiated"
        );
    }

    @NonNull public static UserDetails createUser(
        @NonNull final String username,
        @NonNull final String password
    ) {
        return createUser(username, password, "USER");
    }

    @SuppressWarnings("deprecation")
    @NonNull public static UserDetails createUser(
        @NonNull final String username,
        @NonNull final String password,
        @NonNull final String... roles
    ) {
        return User.withDefaultPasswordEncoder()
            .username(username).password(password).roles(roles)
            .build();
    }
}
