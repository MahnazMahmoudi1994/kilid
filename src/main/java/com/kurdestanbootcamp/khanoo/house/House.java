package com.kurdestanbootcamp.khanoo.house;

import com.kurdestanbootcamp.khanoo.commen.BaseEntity;
import com.kurdestanbootcamp.khanoo.image.Image;
import com.kurdestanbootcamp.khanoo.real_estate.RealEstate;
import com.kurdestanbootcamp.khanoo.zone.Zone;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_house")
@Data
@Audited
public class House extends BaseEntity {

    @Column(name = "sales_price")
    private Double salesPrice;

    @Column(name = "mortgage_price")
    private Double mortgagePrice;

    @Column(name = "rental_price")
    private Double rentalPrice;

    @NotNull
    @Column(name = "meterage")
    private Double meterage;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @NotNull
    @Column(name = "year_of_construction")
    private Integer yearOfConstruction;

    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "number_of_units")
    private Integer numberOfUnits;

    @Column(name = "unit")
    private Integer unit;

    @Column(name = "warehouse")
    private Boolean warehouse;

    @Column(name = "balcony")
    private Boolean balcony;

    @Column(name = "parking")
    private Boolean parking;

    @Column(name = "elevator")
    private Boolean elevator;

    @Column(name = "jacuzzi")
    private Boolean jacuzzi;

    @Column(name = "sauna")
    private Boolean sauna;

    @Column(name = "pool")
    private Boolean pool;

    @Column(name = "loan")
    private Boolean loan;

    @Column(name = "remote_door")
    private Boolean remoteDoor;

    @Column(name = "an_agreement")
    private Boolean anAgreement;

    @Column(name = "central_antenna")
    private Boolean centralAntenna;

    @Column(name = "cooling_device")
    private Boolean coolingDevice;

    @Column(name = "cooling_device_type")
    private String coolingDeviceType;

    @Column(name = "heating_device")
    private Boolean heatingDevice;

    @Column(name = "heating_device_type")
    private String heatingDeviceType;

    @Column(name = "collectivity")
    private Boolean collectivity;

    @Column(name = "exchange")
    private Boolean exchange;

    @Column(name = "description")
    private String description;

    @Column(name = "use_type")
    @Enumerated(value = EnumType.STRING)
    private UseType useType;

    @Column(name = "deal_type")
    @Enumerated(value = EnumType.STRING)
    private DealType dealType;

    @Column(name = "north_or_south")
    @Enumerated(value = EnumType.STRING)
    private NorthOrSouth northOrSouth;

    @Column(name = "property_type_commercial")
    @Enumerated(value = EnumType.STRING)
    private PropertyTypeCommercial propertyTypeCommercial;

    @Column(name = "property_type_residential")
    @Enumerated(value = EnumType.STRING)
    private PropertyTypeResidential propertyTypeResidential;

    @ManyToOne
    @JoinColumn(name = "real_estate_id")
    private RealEstate realEstate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "house",cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;
}