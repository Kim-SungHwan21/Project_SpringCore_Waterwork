package com.nhnacademy.edu.springframework.project.repository;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JsonDataParserTest {

    @Test
    void load() throws IOException {
        final Map<Integer, WaterCharge> dataParsers = new HashMap<>();
        //Reader reader = new FileReader("./src/test/resources/data/Tariff_20220331.json");
        //BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/Tariff_20220331.json")));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("./data/Tariff_20220331.json").getInputStream()));

        ObjectMapper objectMapper = new ObjectMapper();
        List<WaterCharge> waterChargeList = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/Tariff_20220331.json")))) {


            TypeReference<List<HashMap<String,String>>> typeRef = new TypeReference<List<HashMap<String,String>>>(){};
            List<HashMap<String,String>> jsonParsingList = objectMapper.readValue(br, typeRef);

            jsonParsingList.stream().forEach(stringObjectHashMap -> waterChargeList.add(new WaterCharge(parseInt(stringObjectHashMap.get("순번"))
                , stringObjectHashMap.get("지자체명")
                , stringObjectHashMap.get("업종")
                , parseInt(stringObjectHashMap.get("단계"))
                , parseInt(stringObjectHashMap.get("구간시작(세제곱미터)"))
                , parseInt(stringObjectHashMap.get("구간끝(세제곱미터)"))
                , parseLong(stringObjectHashMap.get("구간금액(원)")))));

        }

        assertThat(waterChargeList.size()).isEqualTo(303);
    }

}