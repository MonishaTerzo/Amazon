package com.ecommerce.amazon.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String city;
    private String state;
    private String pincode;
    private String houseno;
    private String area;
    private String landmark;
    private String addresstype;
}
