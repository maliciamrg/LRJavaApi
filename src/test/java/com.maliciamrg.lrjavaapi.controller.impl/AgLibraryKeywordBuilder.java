package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;

import java.util.ArrayList;
import java.util.List;

public class AgLibraryKeywordBuilder {
    public static AgLibraryKeyword getEntity() {
        return  new AgLibraryKeyword(1L,21L );
    }

    public static List<AgLibraryKeywordDTO> getListDTO() {

        List<AgLibraryKeywordDTO> retplus  = new ArrayList();
        retplus.add(new AgLibraryKeywordDTO(1L,21L));
        retplus.add(new AgLibraryKeywordDTO(2L,22L));
        return retplus;
    }

    public static List<AgLibraryKeyword> getListEntities() {

        List<AgLibraryKeyword> retplus  = new ArrayList();
        retplus.add(new AgLibraryKeyword(1L,21L));
        retplus.add(new AgLibraryKeyword(2L,22L));
        return retplus;
    }

    public static AgLibraryKeywordDTO getDTO() {
        return new AgLibraryKeywordDTO(1L,21L);
    }

}


