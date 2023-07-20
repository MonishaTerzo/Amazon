package com.ecommerce.amazon.controller;

import com.ecommerce.amazon.dto.AddressDto;
import com.ecommerce.amazon.model.Address;
import com.ecommerce.amazon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    @PostMapping("/myAddress/{userId}")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDTO, @PathVariable Long userId) {
        AddressDto addedAddress = addressService.addAddress(addressDTO, userId);
        return new ResponseEntity<>(addedAddress, HttpStatus.CREATED);
    }
    @GetMapping("/addAddress/{userId}")
    public List<AddressDto>getAddress(@PathVariable Long userId){
       List<AddressDto> ad=addressService.getAddressByUserId(userId);
       return ad;
    }


}
