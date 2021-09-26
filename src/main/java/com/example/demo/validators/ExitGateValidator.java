package com.example.demo.validators;

import com.example.demo.annotation.Validator;
import com.example.demo.domain.ParkingTicket;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.repositories.ParkingTicketRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Validator
public class ExitGateValidator {

    private final ParkingTicketRepository repository;

    public void validate(Long ExitGateValidator) {

        Optional<ParkingTicket> parkingTicket = repository.findById(ExitGateValidator);
        if (!parkingTicket.isPresent()) {
            throw new ResourceNotFoundException("Ticket not found");
        }
    }
}
