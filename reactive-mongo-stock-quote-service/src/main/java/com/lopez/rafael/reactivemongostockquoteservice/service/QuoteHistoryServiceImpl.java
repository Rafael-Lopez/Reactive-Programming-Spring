package com.lopez.rafael.reactivemongostockquoteservice.service;

import com.lopez.rafael.reactivemongostockquoteservice.domain.QuoteHistory;
import com.lopez.rafael.reactivemongostockquoteservice.model.Quote;
import com.lopez.rafael.reactivemongostockquoteservice.repositories.QuoteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuoteHistoryServiceImpl implements QuoteHistoryService {
    private final QuoteHistoryRepository quoteHistoryRepository;

    @Override
    public Mono<QuoteHistory> saveQuoteToMongo(Quote quote) {
        return quoteHistoryRepository.save(QuoteHistory.builder()
                .ticker(quote.getTicker())
                .price(quote.getPrice())
                .instant(quote.getInstant())
                .build());
    }
}
