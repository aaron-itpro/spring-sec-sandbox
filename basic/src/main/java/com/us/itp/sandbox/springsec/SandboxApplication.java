package com.us.itp.sandbox.springsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;

@SpringBootApplication
public class SandboxApplication {

    public static void main(@NonNull final String[] args) {
        SpringApplication.run(SandboxApplication.class, args);
    }
}
