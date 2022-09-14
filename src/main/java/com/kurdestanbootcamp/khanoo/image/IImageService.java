package com.kurdestanbootcamp.khanoo.image;

import com.kurdestanbootcamp.khanoo.house.House;

import java.util.List;

public interface IImageService {
    Image save(Image image);
    Image update(Image image);
    void delete(Long id);
    Image getById(Long id);
    List<Image> getAll();

    List<Image> getAllByHouse(Long houseId);



}
