package ru.digitalleague.spring_data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.spring_data.model.Car;
import ru.digitalleague.spring_data.service.CarServiceImpl;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServiceImpl carService;

    @GetMapping()
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<List>(carService.findAllCar(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity insert(@RequestBody Car car) {
        try {
            carService.insertCar(car);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            carService.deleteCarById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        carService.deleteAllCar();
    }

    @PutMapping("/updateModel/{id}")
    public void updateModelById(@PathVariable Long id, @RequestBody Car car) {
        carService.updateCarModelById(id, car.getModel());
    }
}
