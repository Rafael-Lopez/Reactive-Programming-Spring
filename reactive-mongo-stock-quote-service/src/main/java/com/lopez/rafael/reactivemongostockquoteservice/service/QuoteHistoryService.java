package com.lopez.rafael.reactivemongostockquoteservice.service;

import com.lopez.rafael.reactivemongostockquoteservice.domain.QuoteHistory;
import com.lopez.rafael.reactivemongostockquoteservice.model.Quote;
import reactor.core.publisher.Mono;

public interface QuoteHistoryService {
    Mono<QuoteHistory> saveQuoteToMongo(Quote quote);
}
