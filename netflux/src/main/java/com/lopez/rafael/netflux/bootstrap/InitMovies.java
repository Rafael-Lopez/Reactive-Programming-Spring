package com.lopez.rafael.netflux.bootstrap;

import com.lopez.rafael.netflux.domain.Movie;
import com.lopez.rafael.netflux.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

// Spring Boot will automatically call the run method of all beans implementing CommandLineRunner
// after the application context has been loaded.
@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas", "Aeon Flux", "Enter the Mono<Void>",
                                "The Fluxxinator", "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                                .map(title -> new Movie(title))
                                .flatMap(movie -> movieRepository.save(movie))
                ).subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(movie -> System.out.println(movie));
                });
    }
}
