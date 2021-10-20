package br.com.cwi.reset.laercio.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class NomeIgualException extends Exception {
    public NomeIgualException(String message) {
        super(message);
    }
}
