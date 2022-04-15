package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CsvDataParser implements DataParsers {

    private final Map<Integer,WaterCharge> dataParsers = new HashMap<>();

    @Override
    public void load() {
        String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("./data/Tariff_20220331.csv")))) {
            while ((line = br.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                if(line.startsWith("순번")){
                    continue;
                }
                dataParsers.put(Integer.parseInt(lineArr[0])
                    , new WaterCharge(Integer.parseInt(lineArr[0])
                        , lineArr[1], lineArr[2]
                        , Integer.parseInt(lineArr[3])
                        , Integer.parseInt(lineArr[4])
                        , Integer.parseInt(lineArr[5])
                        , Integer.parseInt(lineArr[6])
                        , Integer.parseInt(lineArr[7])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<WaterCharge> findAll() {
        return this.dataParsers.values();
    }








}

