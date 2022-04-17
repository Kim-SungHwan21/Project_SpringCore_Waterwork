package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.repository.CsvDataParser;
import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import com.nhnacademy.edu.springframework.project.service.DefaultDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultDataReportService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataReportService;
import com.nhnacademy.edu.springframework.project.service.DefaultWaterSupplyChargeService;
import com.nhnacademy.edu.springframework.project.service.WaterSupplyChargeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfiguration {

    @Bean
    public DataParsers dataParsers() {
        return new CsvDataParser();
    }

    @Bean
    public DataLoadService DataLoadService(DataParsers dataParsers) {
        return new DefaultDataLoadService(dataParsers);
    }

    @Bean
    public WaterSupplyChargeService waterSupplyChargeService(DataParsers dataParsers) {
        return new DefaultWaterSupplyChargeService(dataParsers);
    }

    @Bean
    public DataReportService dataReportService(DataParsers dataParsers) {
        return new DefaultDataReportService(dataParsers);
    }


}
