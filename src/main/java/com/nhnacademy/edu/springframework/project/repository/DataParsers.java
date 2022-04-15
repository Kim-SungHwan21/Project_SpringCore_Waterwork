package com.nhnacademy.edu.springframework.project.repository;

import java.util.Collection;

public interface DataParsers {

    void load();

    Collection<WaterCharge> findAll();

}
