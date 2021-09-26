package com.example.demo.domain;

import com.example.demo.domain.enums.GateType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gate")
public class Gate extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private GateType type;
}
