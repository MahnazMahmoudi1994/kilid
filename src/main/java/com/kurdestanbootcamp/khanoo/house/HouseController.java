package com.kurdestanbootcamp.khanoo.house;

import com.kurdestanbootcamp.khanoo.commen.PagingData;
import com.kurdestanbootcamp.khanoo.commen.SearchCriteria;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/house/")
@AllArgsConstructor
public class HouseController {

    private final IHouseService houseService;
    private HouseMapper houseMapper;


    @Timed("house.save")
    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody HouseDTO houseDTO){
        House house =houseMapper.toHouse(houseDTO);
        houseService.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody HouseDTO houseDTO){
        House house =houseMapper.toHouse(houseDTO);
        houseService.update(house);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<HouseDTO> getById(@PathVariable Long id ){
        House house = houseService.getById(id);
        HouseDTO houseDTO =houseMapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }


    @Timed("house.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<HouseDTO>> getAll(){
        List<House> houses= houseService.getAll();
        List<HouseDTO> houseDTOS = houseMapper.toHouseDTOS(houses);

        return ResponseEntity.ok(houseDTOS);
    }

    @Timed("house.delete")
    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        houseService.delete(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/get-all-by-real-estate/{realEstateId}")
    public ResponseEntity<List<HouseDTO>> getAllByRealEstate(@PathVariable Long realEstateId){
        List<House> houses= houseService.getAllByRealEstate(realEstateId);
        List<HouseDTO> houseDTOS = houseMapper.toHouseDTOS(houses);

        return ResponseEntity.ok(houseDTOS);
    }

    @GetMapping("/v1/get-all-by-zone/{zoneId}")
    public ResponseEntity<List<HouseDTO>> getAllByZone(@PathVariable Long zoneId){
        List<House> houses= houseService.getAllByZone(zoneId);
        List<HouseDTO> houseDTOS = houseMapper.toHouseDTOS(houses);

        return ResponseEntity.ok(houseDTOS);
    }

    @GetMapping("/v1/get-by-city/{cityId}")
    public ResponseEntity<List<HouseDTO>> getAllByCity(@PathVariable Long cityId){
        List<House> houses= houseService.getAllByZoneCity(cityId);
        List<HouseDTO> houseDTOS = houseMapper.toHouseDTOS(houses);

        return ResponseEntity.ok(houseDTOS);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> paging(@PathVariable Integer page, @PathVariable Integer size){

        Page<House> housePage= houseService.paging(page,size);

        int totalPage=  housePage.getTotalPages();
        List<House> data= housePage.getContent();
        List<HouseDTO> houseDTOS= houseMapper.toHouseDTOS(data);

        PagingData<HouseDTO> pagingData=new PagingData<>(totalPage,page,houseDTOS)  ;


        return ResponseEntity.ok(pagingData);
    }

    @Timed("house.searchPaging")
    @PostMapping("/v1/search-paging/")
    public ResponseEntity<PagingData<HouseDTO>> searchPaging(@RequestBody List<SearchCriteria> searchCriteria, Integer page, Integer size){

        Page<House> housePage= houseService.searchPaging(searchCriteria, page, size);

        int totalPage=  housePage.getTotalPages();
        List<House> data= housePage.getContent();

        List<HouseDTO> houseDTOS= houseMapper.toHouseDTOS(data);
        PagingData<HouseDTO> pagingData=new PagingData<>(totalPage,page,houseDTOS)  ;

        return ResponseEntity.ok(pagingData);
    }

    @Timed("house.search")
    @PostMapping("/v1/search")
    public ResponseEntity<List<HouseDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){

        List<House> houses= houseService.search(searchCriteria);
        List<HouseDTO> houseDTOS = houseMapper.toHouseDTOS(houses);
        return ResponseEntity.ok(houseDTOS);
    }



}
