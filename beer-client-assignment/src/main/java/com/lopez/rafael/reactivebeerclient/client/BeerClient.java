package com.lopez.rafael.reactivebeerclient.client;

import com.lopez.rafael.reactivebeerclient.model.BeerDto;
import com.lopez.rafael.reactivebeerclient.model.BeerPagedList;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BeerClient {
    Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                String beerStyle, Boolean showInventoryOnHand);
    Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand);
    Mono<BeerDto> getBeerByUpc(String upc);
    Mono<ResponseEntity<Void>> deleteBeerById(UUID id);
    Mono<ResponseEntity<Void>> createBeer(BeerDto beerDto);
    Mono<ResponseEntity<Void>> updateBeer(UUID id, BeerDto beerDto);
}
