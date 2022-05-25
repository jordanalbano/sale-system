package ar.edu.unrn.service;

import ar.edu.unrn.dto.UserDTO;
import ar.edu.unrn.exceptions.UserUnknownException;

public interface UserService extends GenericService<UserDTO> {

    UserDTO findByUsername(String username) throws UserUnknownException;

}
