package com.example.demo.mappers;

import com.example.demo.domain.ParkingTicket;
import com.example.demo.dto.ParkingTicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ParkingTicketMapper extends BaseMapper<ParkingTicket, ParkingTicketDto>{
}
