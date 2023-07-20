package com.ecommerce.amazon.repository;

import com.ecommerce.amazon.dto.AddressDto;
import com.ecommerce.amazon.model.Address;
import com.ecommerce.amazon.model.Order;
import com.ecommerce.amazon.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface AddressRepository extends JpaRepository<Address,Long> {

List<Address> getAddressByUserId(Long id);

}
