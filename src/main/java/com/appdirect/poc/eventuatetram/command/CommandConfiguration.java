package com.appdirect.poc.eventuatetram.command;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableAutoConfiguration
@Configuration
@EntityScan(basePackages = {"com.appdirect.poc.eventuatetram.command"})
@EnableJpaRepositories
public class CommandConfiguration {
}
