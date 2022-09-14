package com.kurdestanbootcamp.khanoo.zone;

import com.kurdestanbootcamp.khanoo.city.City;
import com.kurdestanbootcamp.khanoo.city.ICityService;
import com.kurdestanbootcamp.khanoo.commen.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ZoneService implements IZoneService{


    private  final ZoneRepository repository;
    private  final ICityService cityService;
    @Override
    public Zone save(Zone zone) {
        Long cityId = zone.getCity().getId();
        City city = cityService.getById(cityId);
        zone.setCity(city);
        return repository.save(zone);
    }

    @Override
    public Zone update(Zone zone) {
        Zone lastZone = getById(zone.getId());

        lastZone.setName(zone.getName());
        Long cityId = zone.getCity().getId();
        City city = cityService.getById(cityId);
        lastZone.setCity(city);

        return repository.save(lastZone);
    }

    @Override
    public void delete(Long id) {

        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Zone getById(Long id) {

        Optional<Zone> optionalZone=repository.findById(id);

        if (!optionalZone.isPresent()){

            throw new NotFoundException("Zone Not Found");
        }

        return optionalZone.get();
    }

    @Override
    public List<Zone> getAll() {

        return (List<Zone>) repository.findAll();
    }

    @Override
    public List<Zone> getAllByCity(Long cityId) {
        City city = cityService.getById(cityId);
        return repository.findAllByCity(city);
    }
}
