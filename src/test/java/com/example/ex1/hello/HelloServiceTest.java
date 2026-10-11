package com.example.ex1.hello;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// Kiểm thử đơn vị thuần, không cần Spring context nên chạy nhanh trên CI.
class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void greetWithName() {
        assertThat(helloService.greet("Spring")).isEqualTo("Hello, Spring!");
    }

    @Test
    void greetWithBlankDefaultsToWorld() {
        assertThat(helloService.greet("  ")).isEqualTo("Hello, World!");
        assertThat(helloService.greet(null)).isEqualTo("Hello, World!");
    }
}
