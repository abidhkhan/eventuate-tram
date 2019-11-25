package com.appdirect.poc.eventuatetram.command;

import javax.persistence.Access;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.AccessType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Entity
@Table(name = "subscriptions")
@Getter
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;
    private String uuid;
    private String tenant;
    private String token;
    private String payload;

}
