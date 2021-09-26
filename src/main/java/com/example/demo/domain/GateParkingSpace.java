package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "gate_parking_space")
public class GateParkingSpace extends BaseEntity{

    @Column(name = "gate_id", nullable = false)
    private Long gateId;

    @Column(name = "parking_space_id", nullable = false)
    private Long parkingSpaceId;
}
