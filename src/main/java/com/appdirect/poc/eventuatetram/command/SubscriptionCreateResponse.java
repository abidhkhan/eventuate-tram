package com.appdirect.poc.eventuatetram.command;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubscriptionCreateResponse {
    private String uuid;
    private String externalId;
}
