package com.example.demo.controllers;

import com.example.demo.domain.ParkingTicket;
import com.example.demo.dto.ParkingTicketDto;
import com.example.demo.mappers.ParkingTicketMapper;
import com.example.demo.services.EntryGateService;
import com.example.demo.services.ExitGateService;
import com.example.demo.validators.ExitGateValidator;
import com.example.demo.validators.ParkingSpaceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/gate")
public class GateController {

    private final EntryGateService entryGateService;
    private final ExitGateService exitGateService;
    private final ParkingTicketMapper mapper;
    private final ParkingSpaceValidator validator;
    private final ExitGateValidator gateValidator;

    @PostMapping("/{parkingSpaceId}")
    public ParkingTicketDto getTicket(@PathVariable Long parkingSpaceId) throws Exception{
        validator.validate(parkingSpaceId);
        ParkingTicket ticket = entryGateService.getTicket(parkingSpaceId);
        ParkingTicketDto dto = this.mapper.mapToDto(ticket);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gateValidator.validate(id);
        exitGateService.acceptTicket(id);
    }


}
