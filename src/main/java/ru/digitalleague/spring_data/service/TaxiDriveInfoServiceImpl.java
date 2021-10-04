package ru.digitalleague.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.spring_data.model.CityQueue;
import ru.digitalleague.spring_data.model.TaxiDriveInfo;
import ru.digitalleague.spring_data.service.repository.TaxiDriveInfoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaxiDriveInfoServiceImpl {

    @Autowired
    private TaxiDriveInfoService taxiDriveInfoService;

    public List<TaxiDriveInfo> findAllTaxiDriveInfo() {
        List<TaxiDriveInfo> listTaxiDriveInfo = new ArrayList<>();
        taxiDriveInfoService.findAll().forEach(listTaxiDriveInfo::add);
        return listTaxiDriveInfo;
    }

    public TaxiDriveInfo insertCityQueue(TaxiDriveInfo taxiDriveInfo) {
        return taxiDriveInfoService.save(taxiDriveInfo);
    }

    public void deleteTaxiDriveInfo(Long id) {
        taxiDriveInfoService.deleteById(id);
    }

    public void deleteAllTaxiDriveInfo() {
        taxiDriveInfoService.deleteAll();
    }

    public void updateNameById(Long id, String first_name, String middle_name, String last_name) {
        taxiDriveInfoService.updateNameById(id, first_name, middle_name, last_name);
    }
}
