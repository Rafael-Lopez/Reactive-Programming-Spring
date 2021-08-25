package com.lopez.rafael.netflux.services;

import com.lopez.rafael.netflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> getMovieById(String id);
    Flux<Movie> getAllMovies();
}
