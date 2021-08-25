package com.lopez.rafael.netflux.controllers;

import com.lopez.rafael.netflux.domain.Movie;
import com.lopez.rafael.netflux.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// If you use @Controller, you need to annotate the methods with @ResponseBody as well.
// This is because the response from our methods needs to be included in the response body.
// MORE ON THIS: @Controller is responsible for preparing a model Map with data to be displayed
// by the view as well as choosing the right view itself. It can also directly write into response
// stream by using @ResponseBody annotation and complete the request.
@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping()
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
