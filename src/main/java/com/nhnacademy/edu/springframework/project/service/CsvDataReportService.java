package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import org.springframework.beans.factory.annotation.Autowired;

public class CsvDataReportService implements DataReportService {

    DataParsers dataParsers;
    WaterSupplyChargeService waterSupplyChargeService;

    @Autowired
    public CsvDataReportService(DataParsers dataParsers) {
        this.dataParsers = dataParsers;
    }

    @Override
    public void Report() {
        dataParsers.load();
        waterSupplyChargeService.calculateCharge();
        System.out.println("test1");
    }
}
