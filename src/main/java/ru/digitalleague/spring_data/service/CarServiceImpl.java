package ru.digitalleague.spring_data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.spring_data.model.Car;
import ru.digitalleague.spring_data.service.repository.CarService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CarServiceImpl {

    @Autowired
    private CarService carService;

    public Car insertCar(Car car) {
        return carService.save(car);
    }
    public void deleteCarById(Long id) {
        carService.deleteById(id);
    }

    public List<Car> findAllCar() {
        List<Car> listCar = new ArrayList<>();
        carService.findAll().forEach(listCar::add);
        return listCar;
    }

    public void deleteAllCar() {
        carService.deleteAll();
    }

    public void updateCarModelById(Long id, String model) {
        carService.updateCarModelById(id, model);
    }
}
