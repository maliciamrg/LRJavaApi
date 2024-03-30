package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryFolderMapper extends GenericMapper<AgLibraryFolder, AgLibraryFolderDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryFolder asEntity(AgLibraryFolderDTO dto);
}