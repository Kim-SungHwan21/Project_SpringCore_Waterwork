package com.nhnacademy.edu.springframework.project.service;

public class WaterBill implements Comparable<WaterBill>{


    private final String city;
    private final String sector;
    private final int unitPrice;

    private long billTotal;

    public WaterBill(String city, String sector, int unitPrice, long billTotal) {
        this.city = city;
        this.sector = sector;
        this.unitPrice = unitPrice;
        this.billTotal = billTotal;
    }


    @Override
    public String toString() {
        return "WaterBill{" +
            "city='" + city + '\'' +
            ", sector='" + sector + '\'' +
            ", unitPrice=" + unitPrice +
            ", billTotal=" + billTotal +
            '}';
    }

    @Override
    public int compareTo(WaterBill o) {
        if(this.billTotal == o.billTotal){
            return 0;
        }
        return this.billTotal < o.billTotal ? -1:1;
    }
}
