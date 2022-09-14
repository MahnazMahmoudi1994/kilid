package com.kurdestanbootcamp.khanoo.city;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/city/")
@AllArgsConstructor
public class CityController {

    private final ICityService cityService;
    private CityMapper cityMapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CityDTO cityDTO){
        City city =cityMapper.toCity(cityDTO);
        cityService.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CityDTO cityDTO){
        City city =cityMapper.toCity(cityDTO);
        cityService.update(city);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id ){
        City city = cityService.getById(id);
        CityDTO cityDTO =cityMapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @Timed("city.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<CityDTO>> getAll(){
        List<City> cities= cityService.getAll();
        List<CityDTO> cityDTOS = cityMapper.toCityDTOS(cities);

        return ResponseEntity.ok(cityDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        cityService.delete(id);
        return ResponseEntity.ok().build();

    }

}
