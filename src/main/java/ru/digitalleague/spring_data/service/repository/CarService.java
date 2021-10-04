package ru.digitalleague.spring_data.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.spring_data.model.Car;
import ru.digitalleague.spring_data.service.repository.custom.CarCustomRepository;

@Repository
public interface CarService extends CrudRepository<Car,Long>, CarCustomRepository {

}
