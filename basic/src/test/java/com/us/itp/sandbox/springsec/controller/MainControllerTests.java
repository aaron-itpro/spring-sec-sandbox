package com.us.itp.sandbox.springsec.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public final class MainControllerTests {

    @Autowired @NonNull private MockMvc mvc;

    @Test
    public void mainPageLoads() throws Exception {
        assertPageLoads("/");
    }

    @Test
    public void mainPageRequiresAuthentication() throws Exception {
        assertPageRequiresAuthentication("/");
    }

    @SuppressWarnings("SameParameterValue")
    private void assertPageLoads(@NonNull final String url) throws Exception {
        mvc.perform(get(url).with(user("user")))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @SuppressWarnings("SameParameterValue")
    private void assertPageRequiresAuthentication(@NonNull final String url) throws Exception {
        mvc.perform(get(url)).andExpect(status().isUnauthorized());
    }
}
