package com.nhnacademy.edu.springframework.project.service;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public interface DataLoadService {
    void dataLoad() throws IOException, ParseException;
}
