package uninter.baozi_store.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends Exception {
    private HttpStatus httpStatus;

    public ApiException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
