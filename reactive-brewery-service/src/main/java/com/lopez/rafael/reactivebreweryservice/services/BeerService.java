package com.lopez.rafael.reactivebreweryservice.services;

import com.lopez.rafael.reactivebreweryservice.web.model.BeerDto;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerPagedList;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    Mono<BeerPagedList> listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
    Mono<BeerDto> getById(Integer beerId, Boolean showInventoryOnHand);
    Mono<BeerDto> saveNewBeer(BeerDto beerDto);
    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
    Mono<BeerDto> getByUpc(String upc);
    void deleteBeerById(Integer beerId);
}
