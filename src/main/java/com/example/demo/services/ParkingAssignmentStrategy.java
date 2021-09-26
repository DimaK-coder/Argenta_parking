package com.example.demo.services;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.dto.ParkingSpaceDto;

import java.util.List;

public interface ParkingAssignmentStrategy {
    List<ParkingSpaceDto> findAllFree();
    void takeParkingSpace(Long parkingSpaceI);
    void releaseParkingSpace(ParkingSpace parkingSpace);

}
