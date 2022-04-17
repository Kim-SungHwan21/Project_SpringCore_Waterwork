package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDataLoadService implements DataLoadService{

    private final DataParsers dataParsers;

    @Autowired
    public DefaultDataLoadService(DataParsers dataParsers) {
        this.dataParsers = dataParsers;
    }

    @Override
    public void dataLoad() throws IOException, ParseException {
        dataParsers.load();
    }
}
