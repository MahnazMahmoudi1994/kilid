package com.kurdestanbootcamp.khanoo.image;

import com.kurdestanbootcamp.khanoo.commen.exception.NotFoundException;
import com.kurdestanbootcamp.khanoo.house.House;
import com.kurdestanbootcamp.khanoo.house.IHouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService implements IImageService {
  private  final ImageRepository repository;
  private  final IHouseService houseService;


    @Override
    public Image save(Image image) {

        Long houseId = image.getHouse().getId();
        House house = houseService.getById(houseId);
        image.setHouse(house);
        return repository.save(image);    }

    @Override
    public Image update(Image image) {
        Image lastImage = getById(image.getId());
        lastImage.setImage(image.getImage());
        Long houseId = image.getHouse().getId();
        House house = houseService.getById(houseId);
        lastImage.setHouse(house);

        return repository.save(lastImage);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);

    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optionalImage =repository.findById(id);

        if (!optionalImage.isPresent()){

            throw new NotFoundException("Image Not Found");
        }

        return optionalImage.get();
    }

    @Override
    public List<Image> getAll() {

        return (List<Image>) repository.findAll();
    }

    @Override
    public List<Image> getAllByHouse(Long houseId) {
        House house = houseService.getById(houseId);
        return repository.findAllByHouse(house);
    }
}