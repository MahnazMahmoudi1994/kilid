package com.kurdestanbootcamp.khanoo.image;

import com.kurdestanbootcamp.khanoo.house.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image,Long> {


    List<Image> findAllByHouse(House house);
}
