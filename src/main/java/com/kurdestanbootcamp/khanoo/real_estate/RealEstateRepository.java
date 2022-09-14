package com.kurdestanbootcamp.khanoo.real_estate;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RealEstateRepository extends PagingAndSortingRepository<RealEstate,Long>{



}
