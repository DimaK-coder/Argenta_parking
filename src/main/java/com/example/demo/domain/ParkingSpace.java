package com.example.demo.domain;

import com.example.demo.domain.enums.ParkingSpaceStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "parking_space")
public class ParkingSpace extends BaseEntity{

    @Column(name = "position")
    private String position;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ParkingSpaceStatus status;

}
