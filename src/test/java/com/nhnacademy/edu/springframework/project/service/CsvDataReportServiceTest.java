package com.nhnacademy.edu.springframework.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.edu.springframework.project.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvDataReportServiceTest {

    DataParsers dataParsers;
    List<WaterBill> waterBills;
    List<WaterBill> sortArray;
    List<WaterBill> reportArrayList;
    @BeforeEach
    void setUp() throws IOException, ParseException {
        dataParsers = new CsvDataParser();
        dataParsers.load();
        waterBills = new ArrayList<>();
        sortArray = new ArrayList<>();
        reportArrayList = new ArrayList<>();
    }

    @Test
    void report() {
        int amount = 10;
        DataParsers dataParsersRepository = dataParsers;
        dataParsersRepository.findAll().stream()
            .forEach(waterCharge -> {
                long result = 0;
                if (amount > waterCharge.getStartSection() && amount < waterCharge.getEndSection()) {
                    result = waterCharge.getUnitPrice();
                    waterBills.add(new WaterBill(waterCharge.getCity()
                        , waterCharge.getSector()
                        , waterCharge.getUnitPrice()
                        , result * amount));
                }
            });

        waterBills.stream().sorted().forEach(waterBill -> sortArray.add(waterBill));

        for (int i = 0; i < 5; i++) {
            reportArrayList.add(sortArray.get(i));
        }
        System.out.println(reportArrayList);

        assertThat(reportArrayList.size()).isEqualTo(5);
    }
}