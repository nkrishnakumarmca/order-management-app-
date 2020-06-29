package com.kk.api.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document("order")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @Id
    private String orderId;
    private String orderStatus;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private List<OrderDetails> orderDetails;
    private Customer customer;
    private Shop shop;
    private Agent agent;

}
