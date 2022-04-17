package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.BootStrap;
import com.nhnacademy.edu.springframework.project.repository.DataParsers;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDataReportService implements DataReportService {

    DataParsers dataParsers;
    WaterSupplyChargeService waterSupplyChargeService;
    private static final Log log = LogFactory.getLog(BootStrap.class);

    @Autowired
    public DefaultDataReportService(DataParsers dataParsers) {
        this.dataParsers = dataParsers;
    }

    @Autowired
    public void DefaultWaterSupplyChargeService(WaterSupplyChargeService waterSupplyChargeService) {
        this.waterSupplyChargeService = waterSupplyChargeService;
    }

    @Override
    public void report(List<WaterBill> reportArrayList) {
        waterSupplyChargeService.reportArrayList(reportArrayList);
        log.info(reportArrayList);
    }
}
