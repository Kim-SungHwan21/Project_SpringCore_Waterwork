package com.nhnacademy.edu.springframework.project.repository;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository
public class JsonDataParser implements DataParsers {

        ObjectMapper objectMapper = new ObjectMapper();
        List<WaterCharge> dataParsers = new ArrayList<>();

    @Override
    public void load() throws IOException, ParseException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/Tariff_20220331.json")))) {

            TypeReference<List<HashMap<String,String>>> typeRef = new TypeReference<List<HashMap<String,String>>>(){};
            List<HashMap<String,String>> jsonParsingList = objectMapper.readValue(br, typeRef);

            jsonParsingList.stream().forEach(stringObjectHashMap -> dataParsers.add(new WaterCharge(parseInt(stringObjectHashMap.get("순번"))
                , stringObjectHashMap.get("지자체명")
                , stringObjectHashMap.get("업종")
                , parseInt(stringObjectHashMap.get("단계"))
                , parseInt(stringObjectHashMap.get("구간시작(세제곱미터)"))
                , parseInt(stringObjectHashMap.get("구간끝(세제곱미터)"))
                , parseLong(stringObjectHashMap.get("구간금액(원)")))));
        }
    }

    @Override
    public Collection<WaterCharge> findAll() {
        return this.dataParsers;
    }

    @Override
    public int size() {
        return dataParsers.size();
    }

}
