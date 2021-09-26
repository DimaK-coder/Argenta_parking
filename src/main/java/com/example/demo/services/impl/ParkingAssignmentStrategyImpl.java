package com.example.demo.services.impl;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.enums.ParkingSpaceStatus;
import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.mappers.ParkingSpaceMapper;
import com.example.demo.repositories.ParkingSpaceRepository;
import com.example.demo.services.ParkingAssignmentStrategy;
import com.example.demo.validators.ParkingSpaceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParkingAssignmentStrategyImpl implements ParkingAssignmentStrategy {

    private final ParkingSpaceRepository repository;
    private final ParkingSpaceMapper mapper;
    private final ParkingSpaceValidator validator;

    @Override
    public List<ParkingSpaceDto> findAllFree() {
        return repository.findAllByStatus(ParkingSpaceStatus.FREE).stream()
                .map(this.mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void takeParkingSpace(Long parkingSpaceId) {
        validator.validate(parkingSpaceId);
        ParkingSpace parkingSpace = repository.findById(parkingSpaceId).get();
        parkingSpace.setStatus(ParkingSpaceStatus.BUSY);
        repository.save(parkingSpace);
    }

    @Override
    public void releaseParkingSpace(Long parkingSpaceId) {
        validator.validate(parkingSpaceId);
        ParkingSpace parkingSpace = repository.findById(parkingSpaceId).get();
        parkingSpace.setStatus(ParkingSpaceStatus.PENDING);
        repository.save(parkingSpace);
    }
}
