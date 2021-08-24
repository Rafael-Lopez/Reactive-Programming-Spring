package com.lopez.rafael.reactiveexamples;

import com.lopez.rafael.reactiveexamples.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

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
}
