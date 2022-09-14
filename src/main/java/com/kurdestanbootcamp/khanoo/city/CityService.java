package com.kurdestanbootcamp.khanoo.city;


import com.kurdestanbootcamp.khanoo.commen.exception.ConflictException;
import com.kurdestanbootcamp.khanoo.commen.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService implements ICityService{
    private final CityRepository repository;


    @Override
    public City save(City city) {

        List<City> cities = getAll();
        for (City city1:cities){
            if (city1.getName().equals(city.getName())){
                throw new ConflictException("This city has already been registered");
            }
        }

        return repository.save(city);
    }

    @Override
    public City update(City city) {
        City lastCity = getById(city.getId());

        List<City> cities = getAll();
        for (City city1:cities){
            if (city1.getName().equals(city.getName())){
                if(city1.getId() == city.getId()){
                    continue;
                }
                throw new ConflictException("This city has already been registered");
            }
        }
        lastCity.setName(city.getName());

        return repository.save(lastCity);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public City getById(Long id) {
        Optional<City> optionalCity=repository.findById(id);

        if (!optionalCity.isPresent()){

            throw new NotFoundException("City Not Found");
        }

        return optionalCity.get();
    }

    @Override
    public List<City> getAll() {
        return (List<City>) repository.findAll();
    }


}
