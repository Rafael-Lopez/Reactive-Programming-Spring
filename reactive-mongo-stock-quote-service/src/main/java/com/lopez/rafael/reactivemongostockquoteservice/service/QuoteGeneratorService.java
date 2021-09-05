package com.lopez.rafael.reactivemongostockquoteservice.service;

import com.lopez.rafael.reactivemongostockquoteservice.model.Quote;
import reactor.core.publisher.Flux;

import java.time.Duration;

public interface QuoteGeneratorService {
    Flux<Quote> fetchQuoteStream(Duration period);
}
