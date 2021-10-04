package ru.digitalleague.spring_data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.spring_data.model.Car;
import ru.digitalleague.spring_data.model.CityQueue;
import ru.digitalleague.spring_data.service.repository.CityQueueService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityQueueServiceImpl {

    @Autowired
    private CityQueueService cityQueueService;

    public CityQueue insertCityQueue(CityQueue cityQueue) {
        return cityQueueService.save(cityQueue);
    }

    public void deleteCityQueueById(Long id) {
        cityQueueService.deleteById(id);
    }

    public List<CityQueue> findAllCityQueue() {
        List<CityQueue> listCityQueue = new ArrayList<>();
        cityQueueService.findAll().forEach(listCityQueue::add);
        return listCityQueue;
    }

    public void deleteAllCityQueue() {
        cityQueueService.deleteAll();
    }

    public void updateNameAndQueueById(Long id, String name, String queue) {
        cityQueueService.updateNameAndQueueById(id, name, queue);
    }
}
