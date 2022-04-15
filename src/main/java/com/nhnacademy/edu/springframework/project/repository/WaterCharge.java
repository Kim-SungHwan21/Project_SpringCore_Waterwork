package com.nhnacademy.edu.springframework.project.repository;

public class WaterCharge {

    private final int number;
    private final String city;
    private final String sector;
    private final int step;
    private final int startSection;
    private final int endSection;
    private final int unitPrice;
    private final int billTotal;

    public WaterCharge(int number, String city, String sector, int step,
                       int startSection, int endSection, int unitPrice, int billTotal) {
        this.number = number;
        this.city = city;
        this.sector = sector;
        this.step = step;
        this.startSection = startSection;
        this.endSection = endSection;
        this.unitPrice = unitPrice;
        this.billTotal = billTotal;
    }

    @Override
    public String toString() {
        return "WaterBill{city='" + city +
            "', sector='" + sector +
            "', unitPrice=" + unitPrice +
            ", billTotal=" + billTotal +
            '}';
    }
}
