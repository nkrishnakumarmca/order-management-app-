package com.kk.api.domain;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("agent")
public class Agent {
    private String agentId;
    private String name;
    private Integer phoneNo;
}
