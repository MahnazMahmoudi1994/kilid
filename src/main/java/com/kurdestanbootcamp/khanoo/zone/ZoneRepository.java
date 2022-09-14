package com.kurdestanbootcamp.khanoo.zone;

import com.kurdestanbootcamp.khanoo.city.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long> {
    List<Zone> findAllByCity(City city);


}
