package com.vgb.boot.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Locale;

@SpringBootApplication
@RestController
public class SpringSandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSandboxApplication.class, args);
    }

    @GetMapping("/")
    public String greet() {
        return "hello";
    }

    @PostMapping("/capitalize/{s}")
    public String capitalize(@NonNull @PathVariable("s") String s, @RequestParam("p") String p,
                             @RequestBody String q) {
        System.out.println("#### "+q);
        return (s+p+q).toUpperCase(Locale.ROOT);
    }
}
