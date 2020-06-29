package com.kk.shop.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String e) {
        super(e);
    }
}
