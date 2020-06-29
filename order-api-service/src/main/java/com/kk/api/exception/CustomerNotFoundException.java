package com.kk.api.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(Exception e) {
        super(e);
    }
}
