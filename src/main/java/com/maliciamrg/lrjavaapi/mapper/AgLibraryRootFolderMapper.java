package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryRootFolderMapper extends GenericMapper<AgLibraryRootFolder, AgLibraryRootFolderDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryRootFolder asEntity(AgLibraryRootFolderDTO dto);
}