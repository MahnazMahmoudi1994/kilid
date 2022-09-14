package com.kurdestanbootcamp.khanoo.zone;


import com.kurdestanbootcamp.khanoo.city.City;

import java.util.List;

public interface IZoneService {

    Zone save(Zone zone);
    Zone update(Zone zone);
    void delete(Long id);
    Zone getById(Long id);
    List<Zone> getAll();

    List<Zone> getAllByCity(Long cityId);

}
