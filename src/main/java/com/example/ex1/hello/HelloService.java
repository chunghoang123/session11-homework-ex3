package com.example.ex1.hello;

import org.springframework.stereotype.Service;

// Service mẫu cho bài tập CI, logic thuần để JUnit test nhanh và ổn định.
@Service
public class HelloService {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name.trim() + "!";
    }
}
