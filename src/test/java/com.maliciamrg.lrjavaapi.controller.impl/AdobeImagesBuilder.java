package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AdobeImagesDTO;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;

import java.util.ArrayList;
import java.util.List;

public class AdobeImagesBuilder {
    public static AdobeImagesDTO getDTO() {
        return new AdobeImagesDTO(1,"21");
    }

    public static AdobeImages getEntity() {
        return new AdobeImages(1,"21");
    }

    public static List<AdobeImagesDTO> getListDTO() {
        List<AdobeImagesDTO> retplus  = new ArrayList();
        retplus.add(new AdobeImagesDTO(1,"21"));
        retplus.add(new AdobeImagesDTO(2,"22"));
        return retplus;
    }

    public static List<AdobeImages> getListEntities() {
        List<AdobeImages> retplus  = new ArrayList();
        retplus.add(new AdobeImages(1,"21"));
        retplus.add(new AdobeImages(2,"22"));
        return retplus;
    }
}
