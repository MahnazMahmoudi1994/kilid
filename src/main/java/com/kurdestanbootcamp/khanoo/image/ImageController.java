package com.kurdestanbootcamp.khanoo.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/image/")
@AllArgsConstructor
public class ImageController {

    private final IImageService imageService;
    private ImageMapper imageMapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ImageDTO imageDTO){
        Image image =imageMapper.toImage(imageDTO);
        imageService.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ImageDTO imageDTO){
        Image image =imageMapper.toImage(imageDTO);
        imageService.update(image);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id ){

    Image image = imageService.getById(id);
    ImageDTO imageDTO = imageMapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<ImageDTO>> getAll(){

    List<Image> images = imageService.getAll();
    List<ImageDTO> imageDTOS = imageMapper.toImageDTOs(images);
        return ResponseEntity.ok(imageDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        imageService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/get-all-by-house/{houseId}")
    public ResponseEntity<List<ImageDTO>> getAllByHouse(@PathVariable Long houseId){
        List<Image> images= imageService.getAllByHouse(houseId);
        List<ImageDTO> imageDTOS = imageMapper.toImageDTOs(images);

        return ResponseEntity.ok(imageDTOS);
    }



}