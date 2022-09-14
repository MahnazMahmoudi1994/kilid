package com.kurdestanbootcamp.khanoo.image;

import com.kurdestanbootcamp.khanoo.commen.BaseDTO;
import com.kurdestanbootcamp.khanoo.house.House;
import com.kurdestanbootcamp.khanoo.house.HouseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private String image;


    @ApiModelProperty(required = true,hidden = false)
    private HouseDTO house;

}