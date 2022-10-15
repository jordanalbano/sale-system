package com.krauser.service;

import com.krauser.dto.UserDTO;
import com.krauser.exceptions.UserUnknownException;

public interface UserService extends GenericService<UserDTO> {

    UserDTO findByUsername(String username) throws UserUnknownException;

}
