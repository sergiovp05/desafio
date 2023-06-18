package cl.ms.admin.user.be.dto;

import cl.ms.admin.user.be.commons.Constantes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    @Email(message = Constantes.MENSAJE_ERROR_EMAIL)
    @Pattern(regexp = Constantes.EMAIL_REGEX, message = Constantes.MENSAJE_ERROR_EMAIL)
    private String email;

    @Pattern(regexp = Constantes.PASS_REGEX, message = Constantes.MENSAJE_ERROR_PASSWORD)
    private String password;
    @Valid
    private List<PhonesDTO> phones;


}
