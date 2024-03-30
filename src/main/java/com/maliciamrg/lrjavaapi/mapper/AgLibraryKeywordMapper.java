package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgLibraryKeywordMapper extends GenericMapper<AgLibraryKeyword, AgLibraryKeywordDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgLibraryKeyword asEntity(AgLibraryKeywordDTO dto);
}