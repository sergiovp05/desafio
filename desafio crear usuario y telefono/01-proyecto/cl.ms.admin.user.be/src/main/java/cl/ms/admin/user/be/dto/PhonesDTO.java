package cl.ms.admin.user.be.dto;

import cl.ms.admin.user.be.commons.Constantes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PhonesDTO {

    @Size(min = 9, max = 9, message = Constantes.MENSAJE_ERROR_NUMBER_LENGTH)
    @Pattern(regexp = Constantes.NUMEBER_REGEX, message = Constantes.MENSAJE_ERROR_NUMBER)
    private String number;
    @JsonProperty("citycode")
    @Pattern(regexp = Constantes.NUMEBER_REGEX, message = Constantes.MENSAJE_ERROR_CITYCODE)
    @Size(min = 1, max = 3, message = Constantes.MENSAJE_ERROR_CITYCODE_LENGTH)
    private String cityCode;
    @JsonProperty("contrycode")
    @Pattern(regexp = Constantes.NUMEBER_REGEX, message = Constantes.MENSAJE_ERROR_CONTRYCODE)
    @Size(min = 1, max = 3, message = Constantes.MENSAJE_ERROR_CONTRYCODE_LENGTH)
    private String contryCode;
}
