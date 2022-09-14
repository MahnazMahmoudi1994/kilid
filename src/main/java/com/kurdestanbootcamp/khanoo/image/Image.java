package com.kurdestanbootcamp.khanoo.image;


import com.kurdestanbootcamp.khanoo.commen.BaseEntity;
import com.kurdestanbootcamp.khanoo.house.House;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "tbl_image")
@Data
@Audited
public class Image extends BaseEntity {

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;



}