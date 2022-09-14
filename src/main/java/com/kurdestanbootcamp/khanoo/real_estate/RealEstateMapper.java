package com.kurdestanbootcamp.khanoo.real_estate;


import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RealEstateMapper {


    @Mappings({
            @Mapping(source = "locationDTO", target = "location", ignore = false, qualifiedByName = "locationDtoToLocation")})
    RealEstate toRealEstate(RealEstateDTO realEstateDTO);

    @Mappings({
            @Mapping(source = "location", target = "locationDTO", ignore = false, qualifiedByName = "locationToLocationDTO")})
    RealEstateDTO toRealEstateDTO(RealEstate realEstate);

    List<RealEstateDTO> toRealEstateDTOS(List<RealEstate> realEstates);

    List<RealEstate> toRealEstates(List<RealEstateDTO> realEstateDTOS);


    @Named("locationDtoToLocation")
    default Point<G2D> convertLocationDtoToLocation(LocationDTO locationDTO) {
        if (locationDTO!=null) {
            Point<G2D> candidPoint= Geometries.mkPoint(new G2D(locationDTO.getLng(), locationDTO.getLat()), CoordinateReferenceSystems.WGS84);
            return  candidPoint;
        }
        return null;
    }

    @Named("locationToLocationDTO")
    default  LocationDTO  convertLocationToLocationDTO(Point<G2D> point) {
        if (point!=null) {
            G2D g2D=   point.getPosition();
            LocationDTO locationDTO=new LocationDTO();
            locationDTO.setLat(g2D.getLat());
            locationDTO.setLng(g2D.getLon());
            return  locationDTO;
        }
        return null;
    }


}
