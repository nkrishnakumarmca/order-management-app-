package com.kk.delivery.exception;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String e) {
        super(e);
    }
}
