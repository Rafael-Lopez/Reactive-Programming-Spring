package com.lopez.rafael.netflux.services;

import com.lopez.rafael.netflux.domain.Movie;
import com.lopez.rafael.netflux.domain.MovieEvent;
import com.lopez.rafael.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {
        // generate() - programmatically create a Flux by generating signals one-by-one via a consumer callback.
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            // next() - Emit only the first item emitted by this Flux, into a new Mono.
            movieEventSynchronousSink.next(new MovieEvent(id, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
