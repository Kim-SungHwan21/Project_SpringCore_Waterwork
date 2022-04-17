package com.nhnacademy.edu.springframework.project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.edu.springframework.project.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import com.nhnacademy.edu.springframework.project.repository.WaterCharge;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvDataLoadServiceTest {

    DataParsers dataParsers;
    Map<Integer, WaterCharge> dataParsers2;

    @BeforeEach
    void setUp() throws IOException, ParseException {
        dataParsers = new CsvDataParser();
        dataParsers2 = new HashMap<>();
        dataParsers.load();
    }

    @Test
    void dataLoad() {
        assertThat(dataParsers.size()).isEqualTo(303);
    }
}