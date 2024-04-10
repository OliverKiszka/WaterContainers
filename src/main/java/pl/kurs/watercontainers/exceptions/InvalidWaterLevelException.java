package pl.kurs.watercontainers.exceptions;

public class InvalidWaterLevelException extends RuntimeException {
    public InvalidWaterLevelException(String message) {
        super(message);
    }
}
