package com.ecommerce.amazon.service;

import com.ecommerce.amazon.dto.UserDto;
import com.ecommerce.amazon.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(int id);
    UserDto createUser(UserDto userDTO);
}
