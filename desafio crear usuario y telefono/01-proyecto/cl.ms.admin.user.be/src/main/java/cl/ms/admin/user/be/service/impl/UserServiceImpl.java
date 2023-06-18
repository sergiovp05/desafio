package cl.ms.admin.user.be.service.impl;

import cl.ms.admin.user.be.commons.Constantes;
import cl.ms.admin.user.be.commons.JwtTokenProvider;
import cl.ms.admin.user.be.dto.PhonesDTO;
import cl.ms.admin.user.be.dto.UserDTO;
import cl.ms.admin.user.be.dto.UserResponseDTO;
import cl.ms.admin.user.be.entity.Phone;
import cl.ms.admin.user.be.entity.User;
import cl.ms.admin.user.be.exception.BusinessException;
import cl.ms.admin.user.be.repository.UserRepository;
import cl.ms.admin.user.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           JwtTokenProvider jwtTokenProvider){
        this.userRepository =userRepository;
        this.jwtTokenProvider =jwtTokenProvider;

    }


    @Override
    public UserResponseDTO create(UserDTO userDTO) {
        validaCorreo(userDTO.getEmail());
         User user  = setUser(userDTO);
         user = userRepository.save(user);

         if(null!=userDTO.getPhones()){
             List<Phone> phList = setPhone(userDTO,user);
             user.setPhones(phList);
             user=userRepository.save(user);
         }
        return responseUserDTO(user);
    }

    private void validaCorreo(String email)throws BusinessException {
        userRepository.findByEmail(email).ifPresent(p -> {
            throw  new BusinessException(HttpStatus.BAD_REQUEST, Constantes.MENSAJE_ERROR_EMAIL_EXISTE);
        });
    }

    private String generarToken(String userName) {
        return jwtTokenProvider.generateToken(userName, 518400000);
    }

    private User setUser(UserDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(generarToken(dto.getEmail()));
        user.setIsactive(true);
        return  user;
    }

    private List<Phone> setPhone (UserDTO dto, User user){
        List<PhonesDTO> phoneList=eliminarDuplicados(dto.getPhones());
        List<Phone> ph=phoneList.stream()
                .map(phoneDTO->
                        new Phone(phoneDTO.getNumber(),
                                phoneDTO.getCityCode(),
                                phoneDTO.getContryCode(),
                                user))
                .collect(Collectors.toList());

        return ph;
    }

    private List<PhonesDTO> eliminarDuplicados(List<PhonesDTO> phones) {
        return phones.stream()
                .distinct().collect(Collectors.toList());
    }


    private UserResponseDTO responseUserDTO (User user) {
        UserResponseDTO salidaDTO= new UserResponseDTO();
        salidaDTO.setCreated(user.getCreated());
        salidaDTO.setId(user.getId());
        salidaDTO.setIsactive(user.isIsactive());
        salidaDTO.setLastLogin(user.getLastLogin());
        salidaDTO.setModified(user.getModified());
        salidaDTO.setToken(user.getToken());
        return salidaDTO;
    }
}
