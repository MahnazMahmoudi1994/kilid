package com.kurdestanbootcamp.khanoo.house;

import com.kurdestanbootcamp.khanoo.city.City;
import com.kurdestanbootcamp.khanoo.city.ICityService;
import com.kurdestanbootcamp.khanoo.commen.SearchCriteria;
import com.kurdestanbootcamp.khanoo.commen.exception.NotFoundException;
import com.kurdestanbootcamp.khanoo.real_estate.IRealEstateService;
import com.kurdestanbootcamp.khanoo.real_estate.RealEstate;
import com.kurdestanbootcamp.khanoo.zone.IZoneService;
import com.kurdestanbootcamp.khanoo.zone.Zone;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseService implements IHouseService{

    private  final HouseRepository repository;

    private  final IRealEstateService realEstateService;
    private  final IZoneService zoneService;
    private  final ICityService cityService;

    @Override
    public House save(House house) {

        Long realEstateId = house.getRealEstate().getId();
        Long zoneId = house.getZone().getId();
        RealEstate realEstate = realEstateService.getById(realEstateId);
        Zone zone = zoneService.getById(zoneId);
        house.setRealEstate(realEstate);
        house.setZone(zone);
        return repository.save(house);
    }

    @Override
    public House update(House house) {
        House lastHouse = getById(house.getId());

        lastHouse.setAddress(house.getAddress());
        lastHouse.setAnAgreement(house.getAnAgreement());
        lastHouse.setBalcony(house.getBalcony());
        lastHouse.setCollectivity(house.getCollectivity());
        lastHouse.setCentralAntenna(house.getCentralAntenna());
        lastHouse.setLocation(house.getLocation());
        lastHouse.setCoolingDevice(house.getCoolingDevice());
        lastHouse.setCoolingDeviceType(house.getCoolingDeviceType());
        lastHouse.setHeatingDevice(house.getHeatingDevice());
        lastHouse.setHeatingDeviceType(house.getHeatingDeviceType());
        lastHouse.setElevator(house.getElevator());
        lastHouse.setParking(house.getParking());
        lastHouse.setFloor(house.getFloor());
        lastHouse.setJacuzzi(house.getJacuzzi());
        lastHouse.setLoan(house.getLoan());
        lastHouse.setSauna(house.getSauna());
        lastHouse.setUnit(house.getUnit());
        lastHouse.setWarehouse(house.getWarehouse());
        lastHouse.setSalesPrice(house.getSalesPrice());
        lastHouse.setMortgagePrice(house.getMortgagePrice());
        lastHouse.setRentalPrice(house.getRentalPrice());
        lastHouse.setRemoteDoor(house.getRemoteDoor());
        lastHouse.setYearOfConstruction(house.getYearOfConstruction());
        lastHouse.setPool(house.getPool());
        lastHouse.setDescription(house.getDescription());
        lastHouse.setNumberOfUnits(house.getNumberOfUnits());
        lastHouse.setNumberOfFloors(house.getNumberOfFloors());
        lastHouse.setNumberOfRooms(house.getNumberOfRooms());
        lastHouse.setMeterage(house.getMeterage());
        lastHouse.setExchange(house.getExchange());
        lastHouse.setUseType(house.getUseType());
        lastHouse.setNorthOrSouth(house.getNorthOrSouth());
        lastHouse.setPropertyTypeCommercial(house.getPropertyTypeCommercial());
        lastHouse.setPropertyTypeResidential(house.getPropertyTypeResidential());
        lastHouse.setDealType(house.getDealType());

        Long realEstateId = house.getRealEstate().getId();
        Long zoneId = house.getZone().getId();
        RealEstate realEstate = realEstateService.getById(realEstateId);
        Zone zone = zoneService.getById(zoneId);
        lastHouse.setRealEstate(realEstate);
        lastHouse.setZone(zone);

        return repository.save(lastHouse);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public House getById(Long id) {
        Optional<House> optionalHouse=repository.findById(id);

        if (!optionalHouse.isPresent()){

            throw new NotFoundException("House Not Found");
        }

        return optionalHouse.get();
    }

    @Override
    public List<House> getAll() {
        return (List<House>) repository.findAll();
    }

    @Override
    public List<House> getAllByRealEstate(Long realEstateId) {

        RealEstate realEstate = realEstateService.getById(realEstateId);
        return repository.findAllByRealEstate(realEstate);
    }

    @Override
    public List<House> getAllByZone(Long zoneId) {
        Zone zone = zoneService.getById(zoneId);
        return repository.findAllByZone(zone);
    }

    @Override
    public List<House> getAllByZoneCity(Long cityId) {
        City city = cityService.getById(cityId);
        return repository.findAllByZone_City(city);
    }

    @Override
    public Page<House> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<House> search(List<SearchCriteria> searchCriteria) {
        HouseSpecification houseSpecification = new HouseSpecification();
        searchCriteria.forEach(criteria -> houseSpecification.add(criteria));

        return repository.findAll(houseSpecification);
    }

    @Override
    public Page<House> searchPaging(List<SearchCriteria> searchCriteria, Integer page, Integer size) {

        HouseSpecification houseSpecification = new HouseSpecification();
        searchCriteria.forEach(criteria -> houseSpecification.add(criteria));


        return repository.findAll(houseSpecification, PageRequest.of(page,size, Sort.by("id").descending()));
    }
}
