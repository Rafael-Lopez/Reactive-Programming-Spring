package com.lopez.rafael.reactiveexamples;

import com.lopez.rafael.reactiveexamples.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

class PersonRepositoryImplTest {

    PersonRepositoryImpl personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void getByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);

        // The block operation stops and waits essentially. It would be the equivalent to
        // Future.get() in java. It defeats the purpose of non-blocking code. Not recommended.
        Person person = personMono.block();

        System.out.println(person.toString());
    }

    @Test
    void getByIdSubscribe() {
        Mono<Person> personMono = personRepository.getById(1);

        // subscribe essentially starts to listen, and can perform actions.
        // Usually nothing happens until subscribe.
        personMono.subscribe(person -> System.out.println(person.toString()));
    }

    @Test
    void getByIdMapFunction() {
        Mono<Person> personMono = personRepository.getById(1);

        // This code doesn't do anything. We need to subscribe to be able to use
        // the information emitted by the reactive repository
//        personMono.map(person -> {
//            System.out.println(person.toString());
//
//            return person.getFirstName();
//        });

        personMono.map(person -> {
            System.out.println(person.toString());

            return person.getFirstName();
        }).subscribe(firstName -> System.out.println("From map: " + firstName));
    }

    @Test
    void fluxTestBlockFirst() {
        Flux<Person> personFlux = personRepository.findAll();

        Person person = personFlux.blockFirst();

        System.out.println(person.toString());
    }

    @Test
    void testFluxSubscribe() {
        Flux<Person> personFlux = personRepository.findAll();

        personFlux.subscribe(person -> {
            System.out.println(person.toString());
        });
    }

    @Test
    void testFluxToListMono() {
        Flux<Person> personFlux = personRepository.findAll();

        Mono<List<Person>> personListMono = personFlux.collectList();

        personListMono.subscribe(list -> {
           list.forEach(person -> {
               System.out.println(person.toString());
           });
        });
    }
}
