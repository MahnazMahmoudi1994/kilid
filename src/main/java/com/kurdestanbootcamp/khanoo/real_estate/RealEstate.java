package com.kurdestanbootcamp.khanoo.real_estate;

import com.kurdestanbootcamp.khanoo.commen.BaseEntity;
import com.kurdestanbootcamp.khanoo.house.House;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_real_estate")
@Data
@Audited
public class RealEstate extends BaseEntity {

    @NotNull
    @Column(name = "real_estate_name")
    private String realEstateName;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @NotNull
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "location")
    private Point<G2D> location;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "realEstate",cascade = CascadeType.ALL)
    private List<House> houses;

}