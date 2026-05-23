package com.kiosko.server.exceptions;

public class BarcodeNotFound extends RuntimeException {
    public BarcodeNotFound(String message) {
        super(message);
    }
}
