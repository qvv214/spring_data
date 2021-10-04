package ru.digitalleague.spring_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.spring_data.model.CityQueue;
import ru.digitalleague.spring_data.service.CityQueueServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/city_queue")
public class CityQueueController {

    @Autowired
    private CityQueueServiceImpl cityQueueService;

    @GetMapping()
    public ResponseEntity<List> findAll() {
        return new ResponseEntity<List>(cityQueueService.findAllCityQueue(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> insert(@RequestBody CityQueue cityQueue) {
        try {
            cityQueueService.insertCityQueue(cityQueue);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException | DataIntegrityViolationException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            cityQueueService.deleteCityQueueById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        cityQueueService.deleteAllCityQueue();
    }

    @PutMapping("/updateNameAndQueue/{id}")
    public void updateNameAndQueueById(@PathVariable Long id, @RequestBody CityQueue cityQueue) {
        cityQueueService.updateNameAndQueueById(id, cityQueue.getName(), cityQueue.getQueue());
    }
}
