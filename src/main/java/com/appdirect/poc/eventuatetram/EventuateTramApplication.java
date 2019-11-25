package com.appdirect.poc.eventuatetram;

import com.appdirect.poc.eventuatetram.config.CommonConfiguration;
import com.appdirect.poc.eventuatetram.config.EventHandlersConfiguration;
import com.appdirect.sdk.ConnectorSdkConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CommonConfiguration.class, ConnectorSdkConfiguration.class, EventHandlersConfiguration.class})
public class EventuateTramApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventuateTramApplication.class, args);
    }

}
