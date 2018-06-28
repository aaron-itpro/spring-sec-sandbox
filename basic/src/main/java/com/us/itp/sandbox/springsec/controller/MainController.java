package com.us.itp.sandbox.springsec.controller;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class MainController {

    @GetMapping("/")
    @NonNull public String main() {
        return "main";
    }
}
