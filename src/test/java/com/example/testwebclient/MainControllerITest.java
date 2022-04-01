package com.example.testwebclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MainControllerITest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void whenPingIsSuccess() {
        webTestClient.get()
            .uri("/ping")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
            .expectBody(String.class)
            .isEqualTo("pong");
    }

}
