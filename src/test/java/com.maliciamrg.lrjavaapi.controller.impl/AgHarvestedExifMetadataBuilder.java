package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;

import java.util.ArrayList;
import java.util.List;

public class AgHarvestedExifMetadataBuilder {
    public static List<AgHarvestedExifMetadataDTO> getListDTO() {
        List<AgHarvestedExifMetadataDTO> retplus  = new ArrayList();
        retplus.add(new AgHarvestedExifMetadataDTO(1L,21));
        retplus.add(new AgHarvestedExifMetadataDTO(2L,22));
        return retplus;
    }

    public static AgHarvestedExifMetadataDTO getDTO() {
        return new AgHarvestedExifMetadataDTO(1L,21);
    }

    public static AgHarvestedExifMetadata getEntity() {
        return new AgHarvestedExifMetadata(1L,21);
    }

    public static List<AgHarvestedExifMetadata> getListEntities() {
        List<AgHarvestedExifMetadata> retplus  = new ArrayList();
        retplus.add(new AgHarvestedExifMetadata(1L,21));
        retplus.add(new AgHarvestedExifMetadata(2L,22));
        return retplus;
    }
}
