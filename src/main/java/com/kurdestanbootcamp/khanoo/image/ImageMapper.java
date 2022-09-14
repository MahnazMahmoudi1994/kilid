package com.kurdestanbootcamp.khanoo.image;

import com.kurdestanbootcamp.khanoo.house.HouseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {HouseMapper.class})
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toImageList(List<ImageDTO> imageDTOS);
    List<ImageDTO> toImageDTOs(List<Image> images);

}
