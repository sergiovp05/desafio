package cl.ms.admin.user.be.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private HttpStatus status;
    public BusinessException(HttpStatus status, String message){
        super(message);
        this.status=status;
    }
}
