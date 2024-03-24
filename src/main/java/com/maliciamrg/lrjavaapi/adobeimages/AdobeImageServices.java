package com.maliciamrg.lrjavaapi.adobeimages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdobeImageServices {

    private final AdobeImageRepository adobeImageRepository;

    @Autowired
    public AdobeImageServices(AdobeImageRepository adobeImageRepository) {
        this.adobeImageRepository = adobeImageRepository;
    }

    public Optional<AdobeImages> getAdobeImageById(String idGlobal) {
        return adobeImageRepository.findByIdGlobal(idGlobal);
    }
    public List<AdobeImages> getAdobeImages() {
        return adobeImageRepository.findAll();
    }

    public void addNewImage(AdobeImages adobeImages) throws IllegalAccessException {

        Optional<AdobeImages> retrievedImage = adobeImageRepository.findByIdLocalOrIdGlobal(adobeImages.getIdLocal(), adobeImages.getIdGlobal());
        if (retrievedImage.isPresent()){
            throw new IllegalAccessException("IDs already used");
        }
        adobeImageRepository.save(adobeImages);
    }

    @Transactional
    public void deleteImage(String idGlobal) {
        if (!adobeImageRepository.existsByIdGlobal(idGlobal)){
            throw new IllegalStateException("image with id "+ idGlobal +" not exist");
        }
        adobeImageRepository.deleteByIdGlobal(idGlobal);
    }

    @Transactional
    public void updateImage(String idGlobal, Integer pick, String fileFormat) {
        AdobeImages adobeImages = adobeImageRepository.findByIdGlobal(idGlobal)
                .orElseThrow(()-> {
                    return new IllegalStateException("image with id " + idGlobal + " not exist");
                });

        if (pick != null) {
            adobeImages.setPick(pick);
        }
        if (fileFormat != null) {
            adobeImages.setFileFormat(fileFormat);
        }
    }
}
