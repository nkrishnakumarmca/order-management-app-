package com.kk.shop.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("orderDetails")
public class OrderDetails {
    private String item;
    private Integer quantity;
}
