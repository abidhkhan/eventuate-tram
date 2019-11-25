package com.appdirect.poc.eventuatetram.handler;

import java.util.UUID;

import com.appdirect.poc.eventuatetram.command.SubscriptionCommandService;
import com.appdirect.poc.eventuatetram.command.SubscriptionCreateRequest;
import com.appdirect.sdk.appmarket.AppmarketEventHandler;
import com.appdirect.sdk.appmarket.events.APIResult;
import com.appdirect.sdk.appmarket.events.ErrorCode;
import com.appdirect.sdk.appmarket.events.SubscriptionOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionOrderHandler implements AppmarketEventHandler<SubscriptionOrder> {
    private ObjectMapper objectMapper;
    private SubscriptionCommandService subscriptionCommandService;

    @Override
    @Async
    public APIResult handle(SubscriptionOrder subscriptionOrder) {

        APIResult apiResult = null;
        try {
            SubscriptionCreateRequest subscriptionCreateRequest = SubscriptionCreateRequest.builder()
                    .uuid(UUID.randomUUID().toString())
                    .tenant(subscriptionOrder.getPartner())
                    .token(subscriptionOrder.getEventToken())
                    .payload(objectMapper.writeValueAsString(subscriptionOrder)).build();
            subscriptionCommandService.create(subscriptionCreateRequest);
            apiResult = APIResult.asyncEventResult("Accepted");
        } catch (Exception ex) {
            apiResult = APIResult.failure(ErrorCode.UNKNOWN_ERROR, ex.getMessage());
        }
        return apiResult;
    }
}
