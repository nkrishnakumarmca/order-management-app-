package com.kk.shop;

import com.kk.shop.exception.OrderNotFoundException;
import com.kk.shop.exception.ShopNotExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ShopPartnerApiExceptionHandler {

    @ExceptionHandler({OrderNotFoundException.class})
    public ResponseEntity<Object> handleOrderNotFoundException(
            Exception ex) {

        return new ResponseEntity<Object>(
                "No order details found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ShopNotExist.class})
    public ResponseEntity<Object> handleCustomerNotFoundException(
            Exception ex) {
        return new ResponseEntity<Object>(
                "Customer details not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<Object>(
                "Please try again later", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
