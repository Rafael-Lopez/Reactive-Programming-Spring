package com.lopez.rafael.reactivebreweryservice.web.functional;

import com.lopez.rafael.reactivebreweryservice.services.BeerService;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeerHandlerV2 {
    private final BeerService beerService;
    // Provided by Spring Boot by default
    private final Validator validator;

    public Mono<ServerResponse> getBeerById(ServerRequest request) {
        Integer beerId = Integer.valueOf(request.pathVariable("beerId"));
        Boolean showInventory = Boolean.valueOf(request.queryParam("showInventory").orElse("false"));

        return beerService.getById(beerId, showInventory)
                .flatMap(beerDto -> {
                   return ServerResponse.ok().bodyValue(beerDto);
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getBeerByUpc(ServerRequest request) {
        String upc = request.pathVariable("upc");

        return beerService.getByUpc(upc)
                .flatMap(beerDto -> {
                    return ServerResponse.ok().bodyValue(beerDto);
                }).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> updateBeer(ServerRequest request) {
        Integer beerId = Integer.valueOf(request.pathVariable("beerId"));

        return request.bodyToMono(BeerDto.class)
                .doOnNext(this::validate)
                .flatMap(beerDto -> {
                    return beerService.updateBeer(beerId, beerDto);
                })
                .flatMap(savedBeerDto -> {
                    log.debug("Saved Beer Id: {}", savedBeerDto.getId());
                    return ServerResponse.noContent().build();
                });
    }

    public Mono<ServerResponse> saveNewBeer(ServerRequest request) {
        Mono<BeerDto> beerDtoMono = request.bodyToMono(BeerDto.class)
                .doOnNext(this::validate);

        return beerService.saveNewBeerMono(beerDtoMono)
                .flatMap(beerDto -> {
                    return ServerResponse.ok()
                            .header("location", BeerRouterConfiguration.BEER_V2_URL + "/" + beerDto.getId())
                            .build();
                });
    }

    // In spring MVC, validation is very simple. We just need to add @Validated (line 83 in BeerController).
    // At this point in time, Webflux doesn't have anything like that. We actually need to wire that
    // in a little more manually.
    private void validate(BeerDto beerDto) {
        Errors errors = new BeanPropertyBindingResult(beerDto, "beerDto");
        validator.validate(beerDto, errors);

        if(errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }
}
