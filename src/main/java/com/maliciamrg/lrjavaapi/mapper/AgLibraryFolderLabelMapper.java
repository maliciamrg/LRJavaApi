package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryFolderLabelMapper extends GenericMapper<AgLibraryFolderLabel, AgLibraryFolderLabelDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryFolderLabel asEntity(AgLibraryFolderLabelDTO dto);
}