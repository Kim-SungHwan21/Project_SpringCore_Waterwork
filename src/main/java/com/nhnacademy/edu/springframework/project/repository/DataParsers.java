package com.nhnacademy.edu.springframework.project.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import org.json.simple.parser.ParseException;

public interface DataParsers {

    void load() throws IOException, ParseException;

    Collection<WaterCharge> findAll();

    int size();
}
