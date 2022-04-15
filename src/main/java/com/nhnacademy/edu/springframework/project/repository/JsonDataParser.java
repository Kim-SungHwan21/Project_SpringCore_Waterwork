package com.nhnacademy.edu.springframework.project.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JsonDataParser implements DataParsers {

    private final Map<Integer,WaterCharge> dataParsers = new HashMap<>();

    @Override
    public void load() {

    }

    @Override
    public Collection<WaterCharge> findAll() {
        return this.dataParsers.values();
    }
}
