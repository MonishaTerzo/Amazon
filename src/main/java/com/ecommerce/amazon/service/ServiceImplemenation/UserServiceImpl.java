package com.ecommerce.amazon.service.ServiceImplemenation;


import com.ecommerce.amazon.dto.UserDto;
import com.ecommerce.amazon.model.User;
import com.ecommerce.amazon.repository.UserRepository;
import com.ecommerce.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
private UserRepository userRepository;


@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id) {
        User user=userRepository.findById(id);
        return user;
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setDob(userDTO.getDob());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setPhoneno(userDTO.getPhoneno());
   user.setPassword(userDTO.getPassword());

        user = userRepository.save(user);

        return convertToDTO(user);
    }

    private UserDto convertToDTO(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setName(user.getName());
        userDTO.setDob(user.getDob());
        userDTO.setGender(user.getGender());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneno(user.getPhoneno());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}

