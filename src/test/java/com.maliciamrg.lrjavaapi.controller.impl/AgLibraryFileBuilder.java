package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFile;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;

import java.util.ArrayList;
import java.util.List;

public class AgLibraryFileBuilder {
    public static List<AgLibraryFileDTO> getListDTO() {
        List<AgLibraryFileDTO> retplus  = new ArrayList();
        retplus.add(new AgLibraryFileDTO(1L,21L));
        retplus.add(new AgLibraryFileDTO(2L,22L));
        return retplus;
    }

    public static List<AgLibraryFile> getListEntities() {
        List<AgLibraryFile> retplus  = new ArrayList();
        retplus.add(new AgLibraryFile(1L,21L));
        retplus.add(new AgLibraryFile(2L,22L));
        return retplus;
    }

    public static AgLibraryFileDTO getDTO() {
        return new AgLibraryFileDTO(1L,21L);
    }

    public static AgLibraryFile getEntity() {
        return new AgLibraryFile(1L,21L);
    }
}
