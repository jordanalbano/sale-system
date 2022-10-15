package com.krauser.controller;

import com.krauser.dto.UserDTO;
import com.krauser.exceptions.UserUnknownException;
import com.krauser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("API de usuarios")
@RequestMapping("/user")
public class UserController {

    private final UserService usersService;

    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/create")
    @ApiOperation("Agregar un usuario, el nombre de usuario no se puede repetir")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO) {
        userDTO = new UserDTO();
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("/all")
    @ApiOperation("Listar todos los usuarios")
    public ResponseEntity<?> list() {
        Collection list = usersService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/findByUsername/{username}")
    @ApiOperation("Recuperar un usuario a partir de su nombre de usuario")
    public ResponseEntity<?> get(@PathVariable String username) {
        UserDTO userDTO = null;
        try {
            userDTO = usersService.findByUsername(username);
        } catch (UserUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre de usuario inexistente");
        }
        return ResponseEntity.ok().body(userDTO);
    }

    @DeleteMapping("/deleteByUsername/{username}")
    @ApiOperation("Eliminar un usuario a partir de su nombre de usuario")
    public ResponseEntity<?> deleteByUsername(@PathVariable String username) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", "¡Usuario eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{username}")
    @ApiOperation("Actualizar los datos de un usuario")
    public ResponseEntity<?> update(@PathVariable String username, @RequestBody UserDTO dto) {
        UserDTO userDTO = new UserDTO();
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    public ResponseEntity<?> enabledUser() {
        UserDTO userDTO = new UserDTO();
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
    @PutMapping("/updatePassword/{password}")
    public ResponseEntity<?> updatePassword(@PathVariable  String password) {
        UserDTO userDTO = new UserDTO();
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

}
