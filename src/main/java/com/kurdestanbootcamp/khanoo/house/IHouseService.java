package com.kurdestanbootcamp.khanoo.house;

import com.kurdestanbootcamp.khanoo.city.City;
import com.kurdestanbootcamp.khanoo.commen.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IHouseService {

    House save(House house);
    House update(House house);
    void delete(Long id);
    House getById(Long id);
    List<House> getAll();

    List<House> getAllByRealEstate(Long realEstateId);

    List<House> getAllByZone(Long zoneId);

    List<House> getAllByZoneCity(Long cityId);

    Page<House> paging(Integer page,Integer size);

    List<House> search(List<SearchCriteria> searchCriteria);

    Page<House> searchPaging(List<SearchCriteria> searchCriteria, Integer page,Integer size);

}
