package com.nhnacademy.edu.springframework.project.repository;


public class WaterCharge {

    private final int number;
    private final String city;
    private final String sector;
    private final int step;
    private final int startSection;
    private final int endSection;
    private final long unitPrice;
//    private final int billTotal;

    public WaterCharge(int number, String city, String sector, int step,
                       int startSection, int endSection, long unitPrice) {
        this.number = number;
        this.city = city;
        this.sector = sector;
        this.step = step;
        this.startSection = startSection;
        this.endSection = endSection;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "WaterCharge{" +
            "number=" + number +
            ", city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", step=" + step +
            ", startSection=" + startSection +
            ", endSection=" + endSection +
            ", unitPrice=" + unitPrice +
            '}';
    }

    public long resultUnitPrice(int amount) {
        long result = 0;
        if (amount > startSection && amount < endSection) {
            result = unitPrice;
        }
        return result;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getUnitPrice() {
        return (int) unitPrice;
    }

    public int getStartSection() {
        return startSection;
    }

    public int getEndSection() {
        return endSection;
    }
}
