package com.us.itp.sandbox.springsec.security;

import static com.us.itp.sandbox.springsec.util.UserUtil.createUser;

import java.util.Collection;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public final class TestUser implements UserDetails {

    @NonNull private final UserDetails details;

    @NonNull private final String rawPassword;
    @NonNull public String getRawPassword() { return rawPassword; }

    public TestUser(
        @NonNull final String username,
        @NonNull final String password,
        @NonNull final String... roles
    ) {
        this.rawPassword = password;
        this.details = createUser(username, password, roles);
    }

    // Delegate implementation of `UserDetails` to `details` member
    @NonNull @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return details.getAuthorities();
    }
    @NonNull @Override public String getPassword() { return details.getPassword(); }
    @NonNull @Override public String getUsername() { return details.getUsername(); }
    @Override public boolean isAccountNonExpired() { return details.isAccountNonExpired(); }
    @Override public boolean isAccountNonLocked() { return details.isAccountNonLocked(); }
    @Override public boolean isCredentialsNonExpired() { return details.isCredentialsNonExpired(); }
    @Override public boolean isEnabled() { return details.isEnabled(); }
}
