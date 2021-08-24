package com.lopez.rafael.reactiveexamples;

import com.lopez.rafael.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {
    @Override
    public Mono<Person> getById(Integer id) {
        return null;
    }

    @Override
    public Flux<Person> findAll() {
        return null;
    }
}
