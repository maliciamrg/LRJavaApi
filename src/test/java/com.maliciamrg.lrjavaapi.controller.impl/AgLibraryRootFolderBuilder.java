package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgLibraryRootFolderBuilder {
    public static AgLibraryRootFolder getEntity() {
        return  new AgLibraryRootFolder(1L,21L,"absolutePath1","name1","relativePathFromCatalog1");
    }

    public static AgLibraryRootFolderDTO getDTO() {
        return new AgLibraryRootFolderDTO(1L,21L,"absolutePath1","name1","relativePathFromCatalog1");
    }

    public static List<AgLibraryRootFolder> getListEntities() {
        //return new AgLibraryRootFolder(1L,2L,"absolutePath","name","relativePathFromCatalog");
        List<AgLibraryRootFolder> retplus  = new ArrayList();
        retplus.add(new AgLibraryRootFolder(1L,21L,"absolutePath1","name1","relativePathFromCatalog1"));
        retplus.add(new AgLibraryRootFolder(2L,22L,"absolutePath2","name2","relativePathFromCatalog2"));
        return retplus;
    }

    public static List<AgLibraryRootFolderDTO> getListDTO() {
        //return new AgLibraryRootFolder(1L,2L,"absolutePath","name","relativePathFromCatalog");
        List<AgLibraryRootFolderDTO> retplus  = new ArrayList();
        retplus.add(new AgLibraryRootFolderDTO(1L,21L,"absolutePath1","name1","relativePathFromCatalog1"));
        retplus.add(new AgLibraryRootFolderDTO(2L,22L,"absolutePath2","name2","relativePathFromCatalog2"));
        return retplus;
    }
}
