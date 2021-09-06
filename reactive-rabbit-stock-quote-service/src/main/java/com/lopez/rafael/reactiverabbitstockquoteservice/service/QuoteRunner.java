package com.lopez.rafael.reactiverabbitstockquoteservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuoteRunner implements CommandLineRunner {
    // @RequiredArgsConstructor generates a constructor with 1 parameter for each
    // field that requires special handling. All non-initialized FINAL fields get a parameter,
    // as well as any fields that are marked as @NonNull that aren't initialized where they are declared
    private final QuoteMessageSender quoteMessageSender;
    private final QuoteGeneratorService quoteGeneratorService;

    @Override
    public void run(String... args) throws Exception {
        quoteGeneratorService.fetchQuoteStream(Duration.ofMillis(100))
                .take(25)
                .log("Got Quote")
                .flatMap(quoteMessageSender::sendQuoteMessage)
                .subscribe(result -> {
                    log.debug("Sent Message to Rabbit");
                }, throwable -> {
                    log.error("Got Error", throwable);
                }, () -> {
                    log.debug("All Done");
                });
    }
}
