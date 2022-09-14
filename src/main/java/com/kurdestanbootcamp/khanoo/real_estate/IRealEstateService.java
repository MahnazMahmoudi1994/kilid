package com.kurdestanbootcamp.khanoo.real_estate;

import java.util.List;

public interface IRealEstateService {

    RealEstate save(RealEstate realEstate);
    RealEstate update(RealEstate realEstate);
    void delete(Long id);
    RealEstate getById(Long id);
    List<RealEstate> getAll();

}
