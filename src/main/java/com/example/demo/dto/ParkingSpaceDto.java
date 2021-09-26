package com.example.demo.dto;

import lombok.Data;

@Data
public class ParkingSpaceDto extends BaseDto{
    private String position;
    private String status;
}
