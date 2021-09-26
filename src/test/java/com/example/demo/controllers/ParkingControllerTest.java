package com.example.demo.controllers;

import com.example.demo.domain.ParkingSpace;
import com.example.demo.domain.enums.ParkingSpaceStatus;
import com.example.demo.dto.ParkingSpaceDto;
import com.example.demo.mappers.ParkingSpaceMapper;
import com.example.demo.repositories.ParkingSpaceRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingController.class)
@DataJdbcTest
class ParkingControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Autowired
    private ParkingSpaceMapper mapper;


    @Test
    void getVacancies() throws Exception {
        ParkingSpace space1 = new ParkingSpace();
        ParkingSpace space2 = new ParkingSpace();
        space1.setId(1L);
        space1.setPosition("A 1");
        space1.setStatus(ParkingSpaceStatus.FREE);
        space2.setId(2L);
        space2.setPosition("A 2");
        space2.setStatus(ParkingSpaceStatus.FREE);
        parkingSpaceRepository.save(space1);
        parkingSpaceRepository.save(space2);

        List<ParkingSpaceDto> listDto = parkingSpaceRepository.findAllByStatus(ParkingSpaceStatus.FREE).stream()
                .map(this.mapper::mapToDto)
                .collect(Collectors.toList());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/parking");
        MvcResult result = mvc.perform(requestBuilder).andReturn();
        assertEquals(listDto, result.getResponse());
    }

    @Test
    @Disabled
    void takeSpace() {
    }

    @Test
    @Disabled
    void releaseSpace() {
    }
}