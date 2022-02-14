package kz.stolik.servicebackendstolik.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class Exception extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String code;
    private HttpStatus httpStatus;
    public Exception(String message, String code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
    }
}
