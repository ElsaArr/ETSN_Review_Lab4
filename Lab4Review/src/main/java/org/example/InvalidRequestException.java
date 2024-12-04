package org.example;

/**
 * InvalidRequestException class is an exception thrown when the request is invalid
 */
public class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        super(message);
    }
}
