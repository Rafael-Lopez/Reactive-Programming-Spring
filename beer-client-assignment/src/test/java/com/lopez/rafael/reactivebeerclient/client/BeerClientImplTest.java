package com.lopez.rafael.reactivebeerclient.client;

import com.lopez.rafael.reactivebeerclient.config.WebClientConfig;
import com.lopez.rafael.reactivebeerclient.model.BeerPagedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BeerClientImplTest {
    BeerClientImpl beerClient;

    @BeforeEach
    void setUp() {
        beerClient = new BeerClientImpl(new WebClientConfig().webClient());
    }

    @Test
    void listBeers() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(null, null, null, null, null);

        BeerPagedList pagedList = beerPagedListMono.block();

        assertThat(pagedList).isNotNull();
        assertThat(pagedList.getContent().size()).isGreaterThan(0);
        System.out.println(pagedList.toList());
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
