package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;

import java.util.ArrayList;
import java.util.List;

public class AgLibraryKeywordImageBuilder {
    public static AgLibraryKeywordImageDTO getDTO() {
        return new AgLibraryKeywordImageDTO(1L,21L,321L);
    }

    public static List<AgLibraryKeywordImageDTO> getListDTO() {
        List<AgLibraryKeywordImageDTO> retplus  = new ArrayList();
        retplus.add(new AgLibraryKeywordImageDTO(1L,21L,321L));
        retplus.add(new AgLibraryKeywordImageDTO(2L,22L,322L));
        return retplus;
    }

    public static List<AgLibraryKeywordImage> getListEntities() {
        List<AgLibraryKeywordImage> retplus  = new ArrayList();
        retplus.add(new AgLibraryKeywordImage(1L,21L,321L));
        retplus.add(new AgLibraryKeywordImage(2L,22L,322L));
        return retplus;
    }

    public static AgLibraryKeywordImage getEntity() {
        return  new AgLibraryKeywordImage(1L,21L,321L);
    }
}
