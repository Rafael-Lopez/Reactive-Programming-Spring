package com.lopez.rafael.reactivebeerclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDto {
    @Null
    private UUID id;
    @NotBlank
    private String beerName;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    @NotBlank
    private BeerStyleEnum beerStyle;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
