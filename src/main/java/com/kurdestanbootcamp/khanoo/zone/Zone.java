package com.kurdestanbootcamp.khanoo.zone;

import com.kurdestanbootcamp.khanoo.city.City;
import com.kurdestanbootcamp.khanoo.commen.BaseEntity;
import com.kurdestanbootcamp.khanoo.house.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_zone")
@Data
@Audited
public class Zone extends BaseEntity {


    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "zone",cascade = CascadeType.ALL)
    private List<House> houses;


}
