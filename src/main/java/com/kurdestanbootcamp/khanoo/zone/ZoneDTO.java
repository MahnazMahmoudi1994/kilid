package com.kurdestanbootcamp.khanoo.zone;

import com.kurdestanbootcamp.khanoo.city.CityDTO;
import com.kurdestanbootcamp.khanoo.commen.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ZoneDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private CityDTO city;

}
