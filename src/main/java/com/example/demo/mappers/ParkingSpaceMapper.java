package com.example.demo.mappers;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.dto.ParkingSpaceDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ParkingSpaceMapper extends BaseMapper<ParkingSpace, ParkingSpaceDto> {
}
