package com.lopez.rafael.reactivebreweryservice.services;

import com.lopez.rafael.reactivebreweryservice.web.model.BeerDto;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerPagedList;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    Mono<BeerPagedList> listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
    Mono<BeerDto> getById(Integer beerId, Boolean showInventoryOnHand);
    Mono<BeerDto> saveNewBeer(BeerDto beerDto);
    Mono<BeerDto> saveNewBeerMono(Mono<BeerDto> beerDto);
    Mono<BeerDto> updateBeer(Integer beerId, BeerDto beerDto);
    Mono<BeerDto> getByUpc(String upc);
    void deleteBeerById(Integer beerId);
    Mono<Void> reactiveDeleteById(Integer beerId);
}
