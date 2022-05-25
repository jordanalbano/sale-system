package ar.edu.unrn.service.impl;

import ar.edu.unrn.dto.UserDTO;
import ar.edu.unrn.exceptions.UserUnknownException;
import ar.edu.unrn.model.User;
import ar.edu.unrn.repository.UserRepository;
import ar.edu.unrn.service.UserService;
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
