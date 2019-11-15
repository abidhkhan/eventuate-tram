package com.appdirect.poc.eventuatetram.consumer;

import com.appdirect.poc.eventuatetram.command.Subscription;
import com.appdirect.poc.eventuatetram.event.SubscriptionCreated;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubscriptionEventConsumer {

    public DomainEventHandlers domainEventHandlers(){
        return DomainEventHandlersBuilder
                .forAggregateType(Subscription.class.getName())
                .onEvent(SubscriptionCreated.class, subscriptionCreatedDomainEventEnvelope -> {
                    SubscriptionCreated subscriptionCreated = subscriptionCreatedDomainEventEnvelope.getEvent();
                    log.info("Subscription created with uuid={}", subscriptionCreated.getUuid());
                })
                .build();
    }
}
