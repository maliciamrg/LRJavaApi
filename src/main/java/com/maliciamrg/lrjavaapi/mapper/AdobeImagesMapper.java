package com.maliciamrg.lrjavaapi.mapper;

import com.maliciamrg.lrjavaapi.dto.AdobeImagesDTO;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AdobeImagesMapper extends GenericMapper<AdobeImages, AdobeImagesDTO> {
    @Override
    @Mapping(target = "idLocal", ignore = false)
    AdobeImages asEntity(AdobeImagesDTO dto);

}