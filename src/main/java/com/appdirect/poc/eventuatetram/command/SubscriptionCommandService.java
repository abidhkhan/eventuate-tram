package com.appdirect.poc.eventuatetram.command;

import static java.util.Arrays.asList;

import com.appdirect.poc.eventuatetram.event.SubscriptionCreated;
import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Service
public class SubscriptionCommandService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public Subscription create(SubscriptionCreateRequest subscriptionCreateRequest) {
        Subscription subscription = Subscription.builder().uuid(subscriptionCreateRequest.getUuid()).build();
        subscription = subscriptionRepository.save(subscription);

        publishTodoEvent(subscription, SubscriptionCreated.builder().uuid(subscription.getUuid()).build());
        log.info("Subscription created event published={}",subscriptionCreateRequest.toString());
        return subscription;
    }

    private void publishTodoEvent(Subscription subscription, DomainEvent... domainEvents) {
        log.info("Domain events published...");
        domainEventPublisher.publish(Subscription.class, subscription.getId(), asList(domainEvents));
    }

    private void publishTodoEvent(Long id, DomainEvent... domainEvents) {
        domainEventPublisher.publish(Subscription.class, id, asList(domainEvents));
    }

}
