package airport.management.system.exceptionModule;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
