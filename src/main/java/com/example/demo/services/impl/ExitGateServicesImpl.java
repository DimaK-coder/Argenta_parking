package com.example.demo.services.impl;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.ParkingTicket;
import com.example.demo.domain.enums.ParkingSpaceStatus;
import com.example.demo.repositories.ParkingSpaceRepository;
import com.example.demo.repositories.ParkingTicketRepository;
import com.example.demo.services.ExitGateService;
import com.example.demo.validators.ExitGateValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExitGateServicesImpl implements ExitGateService {

    private final ParkingTicketRepository parkingTicketRepository;
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final ExitGateValidator validator;

    @Override
    public void acceptTicket(Long ticketId) {

        validator.validate(ticketId);
        ParkingTicket parkingTicket = parkingTicketRepository.getById(ticketId);
        parkingTicketRepository.findById(ticketId);
        ParkingSpace parkingSpace = parkingSpaceRepository.getById(parkingTicket.getParkingSpace().getId());

        parkingSpace.setStatus(ParkingSpaceStatus.FREE);
        parkingTicket.setDeleted(true);
        parkingTicketRepository.save(parkingTicket);
        parkingSpaceRepository.save(parkingSpace);
    }
}
