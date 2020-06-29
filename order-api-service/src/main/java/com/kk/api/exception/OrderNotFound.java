package com.kk.api.exception;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String e) {
        super(e);
    }
}
