package com.appdirect.poc.eventuatetram.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class SubscriptionCreateRequest {
    private String uuid;
    private String tenant;
    private String token;
    private String payload;
}
