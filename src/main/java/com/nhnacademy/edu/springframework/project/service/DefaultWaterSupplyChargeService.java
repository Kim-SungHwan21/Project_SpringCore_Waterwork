package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.BootStrap;
import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DefaultWaterSupplyChargeService implements WaterSupplyChargeService{

    DataParsers dataParsers;

    private final List<WaterBill> waterBills = new ArrayList<>();
    private final List<WaterBill> sortArray = new ArrayList<>();
    private final List<WaterBill> reportArrayList = new ArrayList<>();

    @Autowired
    public DefaultWaterSupplyChargeService(DataParsers dataParsers) {
        this.dataParsers = dataParsers;
    }

    @Override
    public Collection<WaterBill> calculateCharge(int amount) {
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
        return sortArray;
    }

    @Override
    public Collection<WaterBill> reportArrayList(List<WaterBill> sortArray) {
        for (int i = 0; i < 5; i++) {
            reportArrayList.add(sortArray.get(i));
        }
        return reportArrayList;
    }

//    public Collection<WaterBill> result() {
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < 5; i++) {
//            arrayList.add(waterBills.get(i));
//        }
//        return arrayList;
//    }

}
