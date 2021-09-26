package com.example.demo.domain.enums;

public enum ParkingSpotType {
    H("Handicap parking spot"),
    C("Compact parking spot"),
    L("Large parking spot"),
    M("Motorbike parking spot");
    private String type;

    ParkingSpotType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
