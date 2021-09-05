package com.lopez.rafael.reactivemongostockquoteservice.repositories;

import com.lopez.rafael.reactivemongostockquoteservice.domain.QuoteHistory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface QuoteHistoryRepository extends ReactiveMongoRepository<QuoteHistory, String> {
}
