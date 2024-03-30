package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryKeywordImageMapper extends GenericMapper<AgLibraryKeywordImage, AgLibraryKeywordImageDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryKeywordImage asEntity(AgLibraryKeywordImageDTO dto);
}