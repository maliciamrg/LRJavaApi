package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;

import java.util.ArrayList;
import java.util.List;

public class AgInternedExifCameraModelBuilder {
    public static List<AgInternedExifCameraModel> getListEntities() {
        List<AgInternedExifCameraModel> retplus  = new ArrayList();
        retplus.add(new AgInternedExifCameraModel(1L,21,""));
        retplus.add(new AgInternedExifCameraModel(2L,22,""));
        return retplus;
    }

    public static List<AgInternedExifCameraModelDTO> getListDTO() {
        List<AgInternedExifCameraModelDTO> retplus  = new ArrayList();
        retplus.add(new AgInternedExifCameraModelDTO(1L,21,""));
        retplus.add(new AgInternedExifCameraModelDTO(2L,22,""));
        return retplus;
    }

    public static AgInternedExifCameraModelDTO getDTO() {
        return new AgInternedExifCameraModelDTO(1L,21,"");
    }

    public static AgInternedExifCameraModel getEntity() {
        return new AgInternedExifCameraModel(1L,21,"");
    }
}
