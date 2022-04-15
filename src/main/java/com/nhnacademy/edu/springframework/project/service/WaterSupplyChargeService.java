package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.WaterCharge;
import java.util.Collection;

public interface WaterSupplyChargeService {
    Collection<WaterCharge> calculateCharge();
}
