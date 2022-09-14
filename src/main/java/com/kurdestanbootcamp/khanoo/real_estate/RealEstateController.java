package com.kurdestanbootcamp.khanoo.real_estate;


import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/real-estate/")
@AllArgsConstructor
public class RealEstateController {

    private final IRealEstateService realEstateService;
    private RealEstateMapper realEstateMapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody RealEstateDTO realEstateDTO){
        RealEstate realEstate =realEstateMapper.toRealEstate(realEstateDTO);
        realEstateService.save(realEstate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody RealEstateDTO realEstateDTO){
        RealEstate realEstate =realEstateMapper.toRealEstate(realEstateDTO);
        realEstateService.update(realEstate);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<RealEstateDTO> getById(@PathVariable Long id ){
        RealEstate realEstate = realEstateService.getById(id);
        RealEstateDTO realEstateDTO =realEstateMapper.toRealEstateDTO(realEstate);
        return ResponseEntity.ok(realEstateDTO);
    }


    @Timed("realEstate.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<RealEstateDTO>> getAll(){
        List<RealEstate> realEstates= realEstateService.getAll();
        List<RealEstateDTO> realEstateDTOS = realEstateMapper.toRealEstateDTOS(realEstates);

        return ResponseEntity.ok(realEstateDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        realEstateService.delete(id);
        return ResponseEntity.ok().build();


    }

}
