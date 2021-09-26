package com.example.demo.services;

import com.example.demo.domain.ParkingTicket;

public interface ExitGateService {
    void acceptTicket(Long ticketId);
}
