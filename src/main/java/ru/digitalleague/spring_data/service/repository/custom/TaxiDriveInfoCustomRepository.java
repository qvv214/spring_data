package ru.digitalleague.spring_data.service.repository.custom;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TaxiDriveInfoCustomRepository {

    @Modifying
    @Query(value = "update TaxiDriveInfo t set t.first_name = :first_name, t.last_name = :last_name," +
            " t.middle_name = :middle_name where t.driver_id = :id")
    void updateNameById(@Param("id") Long id, @Param("first_name")String first_name,
                        @Param("middle_name")String middle_name, @Param("last_name")String last_name);
}
