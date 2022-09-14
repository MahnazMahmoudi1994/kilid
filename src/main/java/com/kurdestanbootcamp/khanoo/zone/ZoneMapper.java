package com.kurdestanbootcamp.khanoo.zone;

import com.kurdestanbootcamp.khanoo.city.CityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface ZoneMapper {
    Zone toZone(ZoneDTO zoneDTO);
    ZoneDTO toZoneDTO(Zone zone);
    List<ZoneDTO> toZoneDTOS(List<Zone> zones);
    List<Zone> toZones(List<ZoneDTO> zoneDTOS);

}
