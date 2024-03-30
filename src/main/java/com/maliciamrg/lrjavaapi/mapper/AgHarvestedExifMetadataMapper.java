package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AgHarvestedExifMetadataMapper extends GenericMapper<AgHarvestedExifMetadata, AgHarvestedExifMetadataDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AgHarvestedExifMetadata asEntity(AgHarvestedExifMetadataDTO dto);
}