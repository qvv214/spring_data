package ru.digitalleague.spring_data.service.repository.custom;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CarCustomRepository {

    @Modifying
    @Query(value = "update Car c set c.model = :model where c.id = :id")
    void updateCarModelById(@Param("id") Long id, @Param("model") String model);
}
