package com.kk.shop.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customer")
public class Customer {
    private String customerId;
    private String customerName;
    private long phoneNo;
    private String address;
}
