package com.maliciamrg.lrjavaapi.adobeimages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/adobe-images")
public class AdobeImagesController {
    private  final AdobeImageServices adobeImageServices;

    @Autowired
    public AdobeImagesController(AdobeImageServices adobeImageServices) {
        this.adobeImageServices = adobeImageServices;
    }

    @GetMapping(path = "{idGlobal}")
    public Optional<AdobeImages> getAdobeImageById(@PathVariable("idGlobal") String idGlobal) {
        Optional<AdobeImages> adobeImages = adobeImageServices.getAdobeImageById(idGlobal);
        return adobeImages ;
    }
    @GetMapping
    public List<AdobeImages> getAdobeImages() {
        List<AdobeImages> adobeImages = adobeImageServices.getAdobeImages();
        List<String> mythings = adobeImages.stream()
                .map(element-> element.toString())
                .collect(Collectors.toList());
        return adobeImages ;
    }

    @PostMapping
    public void addImage(@RequestBody AdobeImages adobeImages) throws IllegalAccessException {
        adobeImageServices.addNewImage(adobeImages);
    }

    @DeleteMapping(path = "{idGlobal}")
    public void deleteImage(@PathVariable("idGlobal") String idGlobal) {
        adobeImageServices.deleteImage(idGlobal);
    }

    @PutMapping(path = "{idGlobal}")
    public void updateImage(@PathVariable("idGlobal") String idGlobal,
                            @RequestParam(required = false) Integer pick,
                            @RequestParam(required = false) String fileFormat) {
        adobeImageServices.updateImage(idGlobal,pick,fileFormat);
    }
}
