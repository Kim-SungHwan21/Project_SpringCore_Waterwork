package com.nhnacademy.edu.springframework.project.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public interface WaterSupplyChargeService {
    Collection<WaterBill> calculateCharge(int amount);
    Collection<WaterBill> reportArrayList(List<WaterBill> sortArray);
}
