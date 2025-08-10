package airport.management.system.exceptionModule;

import airport.management.system.exceptionModule.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ExceptionResponse> myApiExceptionHandler(ApiException e) {

        String message = e.getMessage();
        ExceptionResponse response = ExceptionResponse.builder()
                .message(message)
                .status(false)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

}
