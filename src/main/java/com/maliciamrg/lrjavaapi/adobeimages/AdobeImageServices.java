package com.maliciamrg.lrjavaapi.adobeimages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdobeImageServices {

    private final AdobeImageRepository adobeImageRepository;

    @Autowired
    public AdobeImageServices(AdobeImageRepository adobeImageRepository) {
        this.adobeImageRepository = adobeImageRepository;
    }

    public Optional<AdobeImages> getAdobeImagesById(Integer idLocal) {
        return adobeImageRepository.findById(idLocal);
    }
    public List<AdobeImages> getAdobeImages() {
        return adobeImageRepository.findAll();
    }
}
