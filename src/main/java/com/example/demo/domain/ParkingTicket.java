package com.example.demo.domain;

import com.example.demo.domain.enums.ParkingSpotType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "parking_ticket")
public class ParkingTicket extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_space_id")
    private ParkingSpace parkingSpace;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ParkingSpotType type;

    @Column(name = "parking_entrance_time")
    private LocalDateTime entranceTime;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    public ParkingTicket() {}

    public ParkingTicket(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
        this.entranceTime = LocalDateTime.now();
    }
}
