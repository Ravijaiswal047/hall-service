package com.marriagehall.hall_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class Hall {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String name;
    private String location;
    private Double price;
    private Integer capacity;
    @Column(length = 1000)
    private String description;

    private UUID vendorId;


}
