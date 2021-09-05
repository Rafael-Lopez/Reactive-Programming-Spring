package com.lopez.rafael.streamingstockquoteservice.service;

import com.lopez.rafael.streamingstockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
