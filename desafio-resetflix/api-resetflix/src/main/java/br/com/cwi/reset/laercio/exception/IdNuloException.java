package br.com.cwi.reset.laercio.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class IdNuloException extends Exception {
    public IdNuloException(String message) {
        super(message);
    }
}
