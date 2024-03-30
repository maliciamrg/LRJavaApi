package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;

import java.util.ArrayList;
import java.util.List;

public class AgLibraryFolderBuilder {
    public static AgLibraryFolderDTO getDTO() {
        return new AgLibraryFolderDTO(1L, 21L);
    }

    public static List<AgLibraryFolderDTO> getListDTO() {
        List<AgLibraryFolderDTO> retplus = new ArrayList();
        retplus.add(new AgLibraryFolderDTO(1L, 21L));
        retplus.add(new AgLibraryFolderDTO(2L, 22L));
        return retplus;
    }

    public static List<AgLibraryFolder> getListEntities() {
        List<AgLibraryFolder> retplus = new ArrayList();
        retplus.add(new AgLibraryFolder(1L, 21L));
        retplus.add(new AgLibraryFolder(2L, 22L));
        return retplus;
    }

    public static AgLibraryFolder getEntity() {
        return new AgLibraryFolder(1L, 21L);
    }
}
