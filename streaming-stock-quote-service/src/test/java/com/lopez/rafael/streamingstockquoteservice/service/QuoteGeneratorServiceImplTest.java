package com.lopez.rafael.streamingstockquoteservice.service;

import com.lopez.rafael.streamingstockquoteservice.model.Quote;
import com.sun.org.apache.xpath.internal.operations.Quo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class QuoteGeneratorServiceImplTest {
    QuoteGeneratorService service;

    @BeforeEach
    void setUp() {
        service = new QuoteGeneratorServiceImpl();
    }

    @Test
    void fetchQuoteStream() throws InterruptedException {
        Flux<Quote> quotesFlux = service.fetchQuoteStream(Duration.ofMillis(100l));

        Consumer<Quote> quoteConsumer = quote -> System.out.println(quote);
        Consumer<Throwable> throwableConsumer = e -> System.out.println(e.getMessage());

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable done = () -> countDownLatch.countDown();

        quotesFlux.take(30)
                .subscribe(quoteConsumer, throwableConsumer, done);

        countDownLatch.await();
    }
}
