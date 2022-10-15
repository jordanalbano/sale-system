package com.krauser.service.impl;

import com.krauser.dto.UserDTO;
import com.krauser.exceptions.UserUnknownException;
import com.krauser.model.User;
import com.krauser.repository.UserRepository;
import com.krauser.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    public Collection<UserDTO> findAll() {
        Collection<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUsername(String username) throws UserUnknownException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UserUnknownException();
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
