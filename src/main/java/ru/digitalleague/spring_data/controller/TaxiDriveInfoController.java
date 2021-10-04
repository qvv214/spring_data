package ru.digitalleague.spring_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.spring_data.model.CityQueue;
import ru.digitalleague.spring_data.model.TaxiDriveInfo;
import ru.digitalleague.spring_data.service.CityQueueServiceImpl;
import ru.digitalleague.spring_data.service.TaxiDriveInfoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/taxi_driver_info")
public class TaxiDriveInfoController {

    @Autowired
    private TaxiDriveInfoServiceImpl taxiDriveInfoService;

    @GetMapping()
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<List>(taxiDriveInfoService.findAllTaxiDriveInfo(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> insert(@RequestBody TaxiDriveInfo taxiDriveInfo) {
        try {
            taxiDriveInfoService.insertCityQueue(taxiDriveInfo);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException | DataIntegrityViolationException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            taxiDriveInfoService.deleteTaxiDriveInfo(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        taxiDriveInfoService.deleteAllTaxiDriveInfo();
    }

    @PutMapping("/updateNameById/{id}")
    public void updateNameAndQueueById(@PathVariable Long id, @RequestBody TaxiDriveInfo taxiDriveInfo) {
        taxiDriveInfoService.updateNameById(id, taxiDriveInfo.getFirst_name(), taxiDriveInfo.getMiddle_name(), taxiDriveInfo.getLast_name());
    }
}
