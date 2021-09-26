package com.example.demo.repositories;

import com.example.demo.domain.GateParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GateParkingSpaceRepository extends JpaRepository<GateParkingSpace, Long> {
}
