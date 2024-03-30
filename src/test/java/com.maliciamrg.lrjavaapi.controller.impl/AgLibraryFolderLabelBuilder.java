package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;

import java.util.ArrayList;
import java.util.List;

public class AgLibraryFolderLabelBuilder {
    public static AgLibraryFolderLabel getEntity() {
        return  new AgLibraryFolderLabel(1L,21L,1,"","","","");
    }

    public static List<AgLibraryFolderLabelDTO> getListDTO() {
        List<AgLibraryFolderLabelDTO> retplus  = new ArrayList();
        retplus.add(new AgLibraryFolderLabelDTO(1L,21L,1,"","","",""));
        retplus.add(new AgLibraryFolderLabelDTO(1L,22L,2,"","","",""));
        return retplus;
    }

    public static List<AgLibraryFolderLabel> getListEntities() {
        List<AgLibraryFolderLabel> retplus  = new ArrayList();
        retplus.add(new AgLibraryFolderLabel(1L,21L,1,"","","",""));
        retplus.add(new AgLibraryFolderLabel(1L,22L,2,"","","",""));
        return retplus;
    }

    public static AgLibraryFolderLabelDTO getDTO() {
        return  new AgLibraryFolderLabelDTO(1L,21L,1,"","","","");
    }
}
