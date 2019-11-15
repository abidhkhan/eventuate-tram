package com.appdirect.poc.eventuatetram.event;

import java.security.DomainCombiner;

import io.eventuate.tram.events.common.DomainEvent;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubscriptionCreated implements DomainEvent {
    private String uuid;
}
