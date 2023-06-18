package cl.ms.admin.user.be.controller;

import cl.ms.admin.user.be.dto.UserDTO;
import cl.ms.admin.user.be.dto.UserResponseDTO;
import cl.ms.admin.user.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> createUser( @RequestBody @Valid UserDTO userDTO) {
        UserResponseDTO response = userService.create(userDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
