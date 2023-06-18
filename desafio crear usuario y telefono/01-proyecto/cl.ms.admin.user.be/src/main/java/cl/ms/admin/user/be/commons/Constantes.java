package cl.ms.admin.user.be.commons;

public class Constantes {

    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String PASS_REGEX = "^(?=.*[A-Z])(?=.*\\d.*\\d)[a-zA-Z\\d]*[a-zA-Z\\d]*[a-z][a-zA-Z\\d]*$";
    public static final String NUMEBER_REGEX = "\\d*";
    public static final String MENSAJE_ERROR_EMAIL = "formato de email inválido";
    public static final String MENSAJE_ERROR_CONTRYCODE = "El campo 'contrycode' solo permite números";
    public static final String MENSAJE_ERROR_CONTRYCODE_LENGTH = "El campo 'contrycode' debe tener una longitud maxima de 3 caracteres";
    public static final String MENSAJE_ERROR_CITYCODE = "El campo 'citycode' solo permite números";
    public static final String MENSAJE_ERROR_CITYCODE_LENGTH = "El campo 'citycode' debe tener una longitud maxima de 3 caracteres";
    public static final String MENSAJE_ERROR_NUMBER = "El campo 'number' solo permite números";
    public static final String MENSAJE_ERROR_NUMBER_LENGTH = "El campo 'number' debe tener una longitud 9 caracteres";
    public static final String MENSAJE_ERROR_PASSWORD = "formato de password inválido";
    public static final String MENSAJE_ERROR_EMAIL_EXISTE = "El correo ya registrado";
    private Constantes(){}

}
