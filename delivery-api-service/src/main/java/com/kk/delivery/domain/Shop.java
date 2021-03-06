package com.kk.delivery.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("shop")
public class Shop {
    private String id;
    private String shopName;
    private String address;
    private long phoneNo;
}
