package com.appdirect.poc.eventuatetram.controller;

import com.appdirect.poc.eventuatetram.command.Subscription;
import com.appdirect.poc.eventuatetram.command.SubscriptionCommandService;
import com.appdirect.poc.eventuatetram.command.SubscriptionCreateRequest;
import com.appdirect.poc.eventuatetram.command.SubscriptionCreateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path="/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionCommandService subscriptionCommandService;

    @RequestMapping(method = RequestMethod.POST)
    public SubscriptionCreateResponse create(SubscriptionCreateRequest subscriptionCreateRequest){
        log.info("Subscription create request received={}", subscriptionCreateRequest.toString());
        Subscription subscription = subscriptionCommandService.create(subscriptionCreateRequest);
        return  SubscriptionCreateResponse.builder().externalId(subscription.getExternalId()).uuid(subscription.getUuid()).build();
    }
}
