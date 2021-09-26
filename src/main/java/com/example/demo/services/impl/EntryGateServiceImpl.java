package com.example.demo.services.impl;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.ParkingTicket;
import com.example.demo.domain.enums.ParkingSpaceStatus;
import com.example.demo.repositories.ParkingSpaceRepository;
import com.example.demo.repositories.ParkingTicketRepository;
import com.example.demo.services.EntryGateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryGateServiceImpl implements EntryGateService {

    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ParkingTicketRepository parkingTicketRepository;

    @Override
    public ParkingTicket getTicket(Long parkingSpaceId) {
        ParkingSpace parkingSpace = parkingSpaceRepository.findById(parkingSpaceId).get();
        parkingSpace.setStatus(ParkingSpaceStatus.PENDING);
        parkingSpaceRepository.save(parkingSpace);
        ParkingTicket parkingTicket = new ParkingTicket(parkingSpace);
        return parkingTicketRepository.save(parkingTicket);
    }
}
