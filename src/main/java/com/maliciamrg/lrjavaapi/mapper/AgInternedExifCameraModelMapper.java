package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgInternedExifCameraModelMapper extends GenericMapper<AgInternedExifCameraModel, AgInternedExifCameraModelDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgInternedExifCameraModel asEntity(AgInternedExifCameraModelDTO dto);
}