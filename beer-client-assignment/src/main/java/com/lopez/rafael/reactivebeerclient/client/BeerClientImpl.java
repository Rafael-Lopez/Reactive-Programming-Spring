package com.lopez.rafael.reactivebeerclient.client;

import com.lopez.rafael.reactivebeerclient.model.BeerDto;
import com.lopez.rafael.reactivebeerclient.model.BeerPagedList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class BeerClientImpl implements BeerClient {

    @Override
    public Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName, String beerStyle, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<BeerDto> getBeerByUpc(String upc) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> deleteBeerById(UUID id) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> createBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> updateBeer(BeerDto beerDto) {
        return null;
    }
}
