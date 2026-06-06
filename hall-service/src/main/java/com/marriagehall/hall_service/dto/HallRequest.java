package com.marriagehall.hall_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class HallRequest {
    private String name;
    private String location;
    private Double price;
    private Integer capacity;
    private  String description;


}
