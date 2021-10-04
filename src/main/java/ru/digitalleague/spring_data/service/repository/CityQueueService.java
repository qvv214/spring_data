package ru.digitalleague.spring_data.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.spring_data.model.CityQueue;
import ru.digitalleague.spring_data.service.repository.custom.CityQueueCustomRepository;

@Repository
public interface CityQueueService extends CrudRepository<CityQueue, Long>, CityQueueCustomRepository {

}
