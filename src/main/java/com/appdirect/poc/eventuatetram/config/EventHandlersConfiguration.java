package com.appdirect.poc.eventuatetram.config;

import com.appdirect.poc.eventuatetram.command.SubscriptionCommandService;
import com.appdirect.poc.eventuatetram.handler.SubscriptionOrderHandler;
import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.SubscriptionOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlersConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public AppmarketEventHandler<SubscriptionOrder> subscriptionOrderHandler(ObjectMapper objectMapper, SubscriptionCommandService subscriptionCommandService) {
        return new SubscriptionOrderHandler(objectMapper, subscriptionCommandService);
    }
}
