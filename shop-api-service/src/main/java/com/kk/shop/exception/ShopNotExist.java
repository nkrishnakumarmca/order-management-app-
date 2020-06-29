package com.kk.shop.exception;

public class ShopNotExist extends RuntimeException {
    public ShopNotExist(Exception e) {
        super(e);
    }
}
