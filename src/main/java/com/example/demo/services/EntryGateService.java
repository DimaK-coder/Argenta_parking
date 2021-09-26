package com.example.demo.services;

import com.example.demo.domain.ParkingTicket;

public interface EntryGateService {
    ParkingTicket getTicket(Long parkingSpaceId);
}
