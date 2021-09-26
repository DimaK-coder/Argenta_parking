package com.example.demo.controllers;

import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.services.ParkingAssignmentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/parking")
public class ParkingController extends BaseController{

    private final ParkingAssignmentStrategy parkingService;

    @GetMapping
    public List<ParkingSpaceDto> getVacancies() throws Exception{
        return parkingService.findAllFree();
    }

    @PutMapping("/take-parking-space/{id}")
    public RequestDto takeSpace(@PathVariable Long id) throws Exception {
        parkingService.takeParkingSpace(id);
        RequestDto requestDto = new RequestDto();
        requestDto.setId(id);
        return requestDto;
    }

    @PutMapping("/release-parking-space/{id}")
    public RequestDto releaseSpace(@PathVariable Long id) throws Exception {
        parkingService.takeParkingSpace(id);
        RequestDto requestDto = new RequestDto();
        requestDto.setId(id);
        return requestDto;
    }


}
