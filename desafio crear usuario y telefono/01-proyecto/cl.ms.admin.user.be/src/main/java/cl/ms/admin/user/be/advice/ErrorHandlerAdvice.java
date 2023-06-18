package cl.ms.admin.user.be.advice;

import cl.ms.admin.user.be.dto.ErrorDTO;
import cl.ms.admin.user.be.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandlerAdvice {

    public static final String ERROR_PREFIX = "ERROR: ";

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<ErrorDTO> errorHandlerException(BusinessException ex) {
        log.error(ERROR_PREFIX + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), ex.getStatus());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> errorHandlerException(MethodArgumentNotValidException ex) {
        String errorMessage = "Error de validacion";
        log.error(ERROR_PREFIX + ex.getMessage(), ex);
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                errorMessage = fieldError.getDefaultMessage();
                break;
            }
        }
        return new ResponseEntity<>(new ErrorDTO(errorMessage), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> errorHandlerException(Exception ex) {
        log.error(ERROR_PREFIX + ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
