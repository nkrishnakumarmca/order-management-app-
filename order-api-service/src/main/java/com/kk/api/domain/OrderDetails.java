package com.kk.api.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("orderDetails")
public class OrderDetails {
    private String item;
    private Integer quantity;
}
