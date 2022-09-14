package com.kurdestanbootcamp.khanoo.house;

import com.kurdestanbootcamp.khanoo.commen.BaseDTO;
import com.kurdestanbootcamp.khanoo.real_estate.RealEstateDTO;
import com.kurdestanbootcamp.khanoo.zone.ZoneDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;


@Data
public class HouseDTO extends BaseDTO {


    @ApiModelProperty(required = false,hidden = false)
    private Double salesPrice;

    @ApiModelProperty(required = false,hidden = false)
    private Double mortgagePrice;

    @ApiModelProperty(required = false,hidden = false)
    private Double rentalPrice;

    @ApiModelProperty(required = true,hidden = false)
    private Double meterage;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private Integer yearOfConstruction;

    @ApiModelProperty(required = false,hidden = false)
    private Integer numberOfRooms;

    @ApiModelProperty(required = false,hidden = false)
    private Integer numberOfFloors;

    @ApiModelProperty(required = false,hidden = false)
    private Integer floor;

    @ApiModelProperty(required = false,hidden = false)
    private Integer numberOfUnits;

    @ApiModelProperty(required = false,hidden = false)
    private Integer unit;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean warehouse;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean balcony;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean parking;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean elevator;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean jacuzzi;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean sauna;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean pool;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean loan;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean remoteDoor;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean anAgreement;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean centralAntenna;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean coolingDevice;

    @ApiModelProperty(required = false,hidden = false)
    private String coolingDeviceType;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean heatingDevice;

    @ApiModelProperty(required = false,hidden = false)
    private String heatingDeviceType;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean collectivity;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean exchange;

    @ApiModelProperty(required = false,hidden = false)
    private String description;

    @ApiModelProperty(required = false,hidden = false)
    private UseType useType;

    @ApiModelProperty(required = false,hidden = false)
    private DealType dealType;

    @ApiModelProperty(required = false,hidden = false)
    private NorthOrSouth northOrSouth;

    @ApiModelProperty(required = false,hidden = false)
    private PropertyTypeCommercial propertyTypeCommercial;

    @ApiModelProperty(required = false,hidden = false)
    private PropertyTypeResidential propertyTypeResidential;

    @ApiModelProperty(required = true,hidden = false)
    private RealEstateDTO realEstate;


    @ApiModelProperty(required = true,hidden = false)
    private ZoneDTO zone;
}
