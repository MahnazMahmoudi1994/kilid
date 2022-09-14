package com.kurdestanbootcamp.khanoo.real_estate;

import com.kurdestanbootcamp.khanoo.commen.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class RealEstateDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String realEstateName;

    @ApiModelProperty(required = true,hidden = false)
    private String logo;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private String address;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;
}
