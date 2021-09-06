package com.lopez.rafael.reactiverabbitstockquoteservice.service;

import com.lopez.rafael.reactiverabbitstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
