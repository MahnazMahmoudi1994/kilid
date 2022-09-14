package com.kurdestanbootcamp.khanoo.zone;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/zone/")
@AllArgsConstructor
public class ZoneController {

    private final IZoneService zoneService;
    private ZoneMapper zoneMapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ZoneDTO zoneDTO){
        Zone zone =zoneMapper.toZone(zoneDTO);
        zoneService.save(zone);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ZoneDTO zoneDTO){
        Zone zone =zoneMapper.toZone(zoneDTO);
        zoneService.update(zone);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<ZoneDTO> getById(@PathVariable Long id ){
        Zone zone = zoneService.getById(id);
        ZoneDTO zoneDTO =zoneMapper.toZoneDTO(zone);
        return ResponseEntity.ok(zoneDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<ZoneDTO>> getAll(){
        List<Zone> zones= zoneService.getAll();
        List<ZoneDTO> zoneDTOS = zoneMapper.toZoneDTOS(zones);

        return ResponseEntity.ok(zoneDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        zoneService.delete(id);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/v1/get-all-by-city/{cityId}")
    public ResponseEntity<List<ZoneDTO>> getAllByCity(@PathVariable Long cityId){
        List<Zone> zones= zoneService.getAllByCity(cityId);
        List<ZoneDTO> zoneDTOS = zoneMapper.toZoneDTOS(zones);

        return ResponseEntity.ok(zoneDTOS);
    }



}
