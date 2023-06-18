package cl.ms.admin.user.be.service;

import cl.ms.admin.user.be.dto.UserDTO;
import cl.ms.admin.user.be.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO create(UserDTO userDTO);
    

}
