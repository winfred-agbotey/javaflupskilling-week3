package com.mawulidev.partfour.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawulidev.partfour.dto.UserDTO;
import com.mawulidev.partfour.model.User;
import com.mawulidev.partfour.repository.UserRepository;
import com.mawulidev.partfour.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = mapper.convertValue(userDTO, User.class);

        return mapper.convertValue(userRepository.createUser(user), UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return mapper.convertValue(userRepository.getUserById(id), UserDTO.class);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = mapper.convertValue(userDTO, User.class);
        return mapper.convertValue(userRepository.updateUser(id, user), UserDTO.class);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public Map<Long, User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
