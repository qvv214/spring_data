package ru.digitalleague.spring_data.service.repository.custom;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CityQueueCustomRepository {

    @Modifying
    @Query(value = "update CityQueue c set c.name = :name, c.queue = :queue where c.city_id = :id")
    void updateNameAndQueueById(@Param("id") Long id, @Param("name") String name, @Param("queue") String queue);
}
