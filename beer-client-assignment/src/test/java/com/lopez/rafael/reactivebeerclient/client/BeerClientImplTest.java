package com.lopez.rafael.reactivebeerclient.client;

import com.lopez.rafael.reactivebeerclient.config.WebClientConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class BeerClientImplTest {
    BeerClientImpl beerClient;

    @BeforeEach
    void setUp() {
        beerClient = new BeerClientImpl(new WebClientConfig().webClient());
    }

    @Test
    void listBeers() {
    }

    @Test
    void getBeerById() {
    }

    @Test
    void getBeerByUpc() {
    }

    @Test
    void deleteBeerById() {
    }

    @Test
    void createBeer() {
    }

    @Test
    void updateBeer() {
    }
}
