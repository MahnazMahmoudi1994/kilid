package com.kurdestanbootcamp.khanoo.city;

import com.kurdestanbootcamp.khanoo.commen.BaseEntity;
import com.kurdestanbootcamp.khanoo.image.Image;
import com.kurdestanbootcamp.khanoo.zone.Zone;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_city")
@Data
@Audited
public class City extends BaseEntity {


    @NotNull
    @Column(name = "name",unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<Zone> zones;

}
