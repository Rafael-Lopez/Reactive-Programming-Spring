package com.lopez.rafael.reactivebreweryservice.web.mappers;

import com.lopez.rafael.reactivebreweryservice.domain.Customer;
import com.lopez.rafael.reactivebreweryservice.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto customerToCustomerDto(Customer customer);
}
