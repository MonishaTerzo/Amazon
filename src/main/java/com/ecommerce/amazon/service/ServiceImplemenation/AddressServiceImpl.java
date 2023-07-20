package com.ecommerce.amazon.service.ServiceImplemenation;

import com.ecommerce.amazon.dto.AddressDto;
import com.ecommerce.amazon.model.Address;
import com.ecommerce.amazon.model.User;
import com.ecommerce.amazon.repository.AddressRepository;
import com.ecommerce.amazon.repository.UserRepository;
import com.ecommerce.amazon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

  @Override
    public AddressDto addAddress(AddressDto addressDTO, Long userId) {
        User user = userRepository.getById(userId);
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setPincode(addressDTO.getPincode());
        address.setHouseno(addressDTO.getHouseno());
        address.setArea(addressDTO.getArea());
        address.setLandmark(addressDTO.getLandmark());
        address.setAddresstype(addressDTO.getAddresstype());
        address.setUser(user);

        address = addressRepository.save(address);

        return convertToDTO(address);
    }

    @Override
    public List<AddressDto> getAddressByUserId(Long userId) {
         return addressRepository.getAddressByUserId(userId).stream()
                 .map(x->convertToDTO(x)).collect(Collectors.toList());

    }

    private AddressDto convertToDTO(Address address) {
        AddressDto addressDTO = new AddressDto();
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPincode(address.getPincode());
        addressDTO.setHouseno(address.getHouseno());
        addressDTO.setArea(address.getArea());
        addressDTO.setLandmark(address.getLandmark());
        addressDTO.setAddresstype(address.getAddresstype());
        return addressDTO;
    }
}

