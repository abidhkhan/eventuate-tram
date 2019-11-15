package com.appdirect.poc.eventuatetram.config;

import com.appdirect.poc.eventuatetram.command.CommandConfiguration;
import com.appdirect.poc.eventuatetram.consumer.SubscriptionEventConsumer;
import io.eventuate.tram.consumer.common.NoopDuplicateMessageDetector;
import io.eventuate.tram.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommandConfiguration.class, TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class, NoopDuplicateMessageDetector.class, EventuateTramKafkaMessageConsumerConfiguration.class, TramEventSubscriberConfiguration.class})
//@Import({CommandConfiguration.class})
public class CommonConfiguration {
    @Bean
    public SubscriptionEventConsumer subscriptionEventConsumer() {
        return new SubscriptionEventConsumer();
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(SubscriptionEventConsumer subscriptionEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
        return domainEventDispatcherFactory.make("subscriptionServiceEvents", subscriptionEventConsumer.domainEventHandlers());
    }
}
