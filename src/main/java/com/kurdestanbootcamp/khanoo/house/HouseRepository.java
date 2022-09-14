package com.kurdestanbootcamp.khanoo.house;


import com.kurdestanbootcamp.khanoo.city.City;
import com.kurdestanbootcamp.khanoo.real_estate.RealEstate;
import com.kurdestanbootcamp.khanoo.zone.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> , JpaSpecificationExecutor<House> {

    List<House> findAllByRealEstate(RealEstate realEstate);
    List<House> findAllByZone(Zone zone);

    List<House> findAllByZone_City(City city);

    Page<House> findAll(Pageable pageable);

    //search
    List<House> findAll(Specification<House> specification);

    Page<House> findAll(Specification<House> specification, Pageable pageable);
}
