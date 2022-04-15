package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import com.nhnacademy.edu.springframework.project.repository.WaterCharge;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultWaterSupplyChargeService implements WaterSupplyChargeService{

    DataParsers dataParsers;

    @Autowired
    public DefaultWaterSupplyChargeService(DataParsers dataParsers) {
        this.dataParsers = dataParsers;
    }

    @Override
    public Collection<WaterCharge> calculateCharge() {
        DataParsers dataParsersRepository = dataParsers;


        return null;
    }
}
