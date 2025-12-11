package com.farmacia.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui.html"; // Redireciona para Swagger
        // ou return "index"; // se tiver template
    }
}