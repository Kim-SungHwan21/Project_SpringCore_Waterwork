package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.project.repository.JsonDataParser;
import com.nhnacademy.edu.springframework.project.service.DefaultDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultDataReportService;
import com.nhnacademy.edu.springframework.project.service.DefaultWaterSupplyChargeService;
import com.nhnacademy.edu.springframework.project.service.WaterBill;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    static Scanner in = new Scanner(System.in);
    static int amount;
    private static final Log log = LogFactory.getLog(BootStrap.class);
    public static void main(String[] args) {


        //주석을 제거 하여 파일 선택
        String fileName = "./data/Tariff_20220331.csv";
    //    String fileName = "./data/Tariff_20220331.json";

        String fe = FilenameUtils.getExtension(fileName);

        try (
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework")) {
            if (fe.equals("csv")) {
                context.getBean("csvDataParser", CsvDataParser.class).load();
            } else if (fe.equals("json")){
                context.getBean("jsonDataParser", JsonDataParser.class).load();
            }
            context.getBean("defaultDataLoadService", DefaultDataLoadService.class).dataLoad();
            log.info("상수도 사용량을 입력해주세요.");
            amount = in.nextInt();

            List<WaterBill> sortArraylist = (List<WaterBill>) context.getBean("defaultWaterSupplyChargeService", DefaultWaterSupplyChargeService.class).calculateCharge(amount);
            List<WaterBill> reportArrayList = (List<WaterBill>) context.getBean("defaultWaterSupplyChargeService", DefaultWaterSupplyChargeService.class).reportArrayList(sortArraylist);
            context.getBean("defaultDataReportService", DefaultDataReportService.class).report(reportArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
