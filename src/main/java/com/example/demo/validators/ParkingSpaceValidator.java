package com.example.demo.validators;

import com.example.demo.annotation.Validator;
import com.example.demo.domain.ParkingSpace;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.repositories.ParkingSpaceRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@Validator
public class ParkingSpaceValidator {

    private final ParkingSpaceRepository repository;

    public void validate(Long spaceId) {
        Optional<ParkingSpace> parkingSpace = repository.findById(spaceId);
        if (!parkingSpace.isPresent()) {
            throw new ResourceNotFoundException("Space not found");
        }
    }
}
