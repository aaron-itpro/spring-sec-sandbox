package com.us.itp.sandbox.springsec.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;

import com.us.itp.sandbox.springsec.security.TestUser;
import com.us.itp.sandbox.springsec.service.UserRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public final class LoginControllerTests {

    @Configuration
    static class Config {
        @NonNull @Bean TestUser user() { return new TestUser("bullwinkle", "daMoose"); }
        @NonNull @Bean UserRegistry registry() { return new UserRegistry(user()); }
    }

    @NonNull @Autowired MockMvc mvc;
    @NonNull @Autowired TestUser user;

    @Test
    public void userCanLogin() throws Exception {
        mvc.perform(loginAs(user)).andExpect(authenticated());
    }

    @Test
    public void unknownUserCantLogin() throws Exception {
        final TestUser badnik = new TestUser("boris", "diemoose");
        mvc.perform(loginAs(badnik)).andExpect(unauthenticated());
    }

    @NonNull private FormLoginRequestBuilder loginAs(@NonNull final TestUser user) {
        return formLogin().user(user.getUsername()).password(user.getRawPassword());
    }
}
