package airport.management.system.exceptionModule;

public class ApiException extends RuntimeException {

    public ApiException(){
    }

    public ApiException(String message) {

        super(message);

    }

}
