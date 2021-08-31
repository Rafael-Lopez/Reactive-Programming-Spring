package com.lopez.rafael.reactivebreweryservice.web.mappers;

import com.lopez.rafael.reactivebreweryservice.domain.Beer;
import com.lopez.rafael.reactivebreweryservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
