package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.AddressDto;
import com.ecommerce.amazon.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    AddressDto addAddress(AddressDto addressDTO, Long userId);
    List<AddressDto> getAddressByUserId(Long userId);
}
