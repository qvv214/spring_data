package ru.digitalleague.spring_data.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digitalleague.spring_data.model.TaxiDriveInfo;
import ru.digitalleague.spring_data.service.repository.custom.TaxiDriveInfoCustomRepository;

@Repository
public interface TaxiDriveInfoService extends CrudRepository<TaxiDriveInfo, Long> , TaxiDriveInfoCustomRepository {

}
