package com.example.demo.dto;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.enums.ParkingSpotType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingTicketDto extends BaseDto{
    private ParkingSpace parkingSpace;
    private ParkingSpotType parkingSpotType;
    private LocalDateTime entranceTime;
    private Boolean deleted;
}
