package com.kurdestanbootcamp.khanoo.real_estate;


import com.kurdestanbootcamp.khanoo.commen.exception.ConflictException;
import com.kurdestanbootcamp.khanoo.commen.exception.NotFoundException;
import com.kurdestanbootcamp.khanoo.zone.IZoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RealEstateService implements IRealEstateService{
    private  final RealEstateRepository repository;

    @Override
    public RealEstate save(RealEstate realEstate) {

        List<RealEstate> realEstates = getAll();
        for(RealEstate realEstate1:realEstates){
            if(realEstate1.getPhoneNumber().equals(realEstate.getPhoneNumber())){
                throw new ConflictException("This phone number is already registered");
            }
        }

        return repository.save(realEstate);
    }

    @Override
    public RealEstate update(RealEstate realEstate) {
        RealEstate lastRealEstate = getById(realEstate.getId());
        List<RealEstate> realEstates = getAll();
        for(RealEstate realEstate1:realEstates){
            if(realEstate1.getPhoneNumber().equals(realEstate.getPhoneNumber())){
                if(realEstate1.getId() == realEstate.getId()){
                    continue;
                }
                throw new ConflictException("This phone number is already registered");
            }
        }

        lastRealEstate.setRealEstateName(realEstate.getRealEstateName());
        lastRealEstate.setPhoneNumber(realEstate.getPhoneNumber());
        lastRealEstate.setAddress(realEstate.getAddress());
        lastRealEstate.setLogo(realEstate.getLogo());
        lastRealEstate.setLocation(realEstate.getLocation());

        return repository.save(lastRealEstate);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public RealEstate getById(Long id) {
        Optional<RealEstate> optionalRealEstate=repository.findById(id);

        if (!optionalRealEstate.isPresent()){

            throw new NotFoundException("RealEstate Not Found");
        }

        return optionalRealEstate.get();
    }

    @Override
    public List<RealEstate> getAll() {

        return (List<RealEstate>) repository.findAll();
    }




}
