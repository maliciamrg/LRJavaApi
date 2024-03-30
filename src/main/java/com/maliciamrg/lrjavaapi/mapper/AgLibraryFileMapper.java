package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryFileMapper extends GenericMapper<AgLibraryFile, AgLibraryFileDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryFile asEntity(AgLibraryFileDTO dto);
}