package cl.ms.admin.user.be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {
    private UUID id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime created;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime modified;
    @JsonProperty("last_login")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime lastLogin;

    private String token;
    private boolean isactive;
}
