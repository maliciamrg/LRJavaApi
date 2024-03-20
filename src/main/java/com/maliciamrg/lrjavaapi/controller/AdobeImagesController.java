package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/{idLocal}")
    public Optional<AdobeImages> getAdobeImagesById(@PathVariable("idLocal") Integer idLocal) {
        Optional<AdobeImages> adobeImages = adobeImageServices.getAdobeImagesById(idLocal);
        return adobeImages ;
    }
    @GetMapping(value = "/all")
    public List<String> getAdobeImages() {
        List<AdobeImages> adobeImages = adobeImageServices.getAdobeImages();
        List<String> mythings = adobeImages.stream()
                .map(element-> element.toString())
                .collect(Collectors.toList());
        return mythings ;
    }
}
