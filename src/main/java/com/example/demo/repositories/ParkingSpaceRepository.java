package com.example.demo.repositories;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.enums.ParkingSpaceStatus;

import java.util.List;

public interface ParkingSpaceRepository extends Repository<ParkingSpace> {

    List<ParkingSpace> findAllByStatus(ParkingSpaceStatus status);
}
