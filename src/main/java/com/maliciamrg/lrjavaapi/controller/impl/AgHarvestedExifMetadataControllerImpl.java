package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgHarvestedExifMetadataController;
import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import com.maliciamrg.lrjavaapi.mapper.AgHarvestedExifMetadataMapper;
import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import com.maliciamrg.lrjavaapi.service.AgHarvestedExifMetadataService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-harvested-exif-metadata")
@RestController
public class AgHarvestedExifMetadataControllerImpl implements AgHarvestedExifMetadataController {
    private final AgHarvestedExifMetadataService agHarvestedExifMetadataService;
    private final AgHarvestedExifMetadataMapper agHarvestedExifMetadataMapper;

    public AgHarvestedExifMetadataControllerImpl(AgHarvestedExifMetadataService agHarvestedExifMetadataService, AgHarvestedExifMetadataMapper agHarvestedExifMetadataMapper) {
        this.agHarvestedExifMetadataService = agHarvestedExifMetadataService;
        this.agHarvestedExifMetadataMapper = agHarvestedExifMetadataMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgHarvestedExifMetadataDTO save(@RequestBody AgHarvestedExifMetadataDTO agHarvestedExifMetadataDTO) {
        AgHarvestedExifMetadata agHarvestedExifMetadata = agHarvestedExifMetadataMapper.asEntity(agHarvestedExifMetadataDTO);
        return agHarvestedExifMetadataMapper.asDTO(agHarvestedExifMetadataService.save(agHarvestedExifMetadata));
    }

    @Override
    @GetMapping("/{id}")
    public AgHarvestedExifMetadataDTO findById(@PathVariable("id") Long id) {
        AgHarvestedExifMetadata agHarvestedExifMetadata = agHarvestedExifMetadataService.findById(id).orElse(null);
        return agHarvestedExifMetadataMapper.asDTO(agHarvestedExifMetadata);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agHarvestedExifMetadataService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgHarvestedExifMetadataDTO> list() {
        return agHarvestedExifMetadataMapper.asDTOList(agHarvestedExifMetadataService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgHarvestedExifMetadataDTO> pageQuery(Pageable pageable) {
        Page<AgHarvestedExifMetadata> agHarvestedExifMetadataPage = agHarvestedExifMetadataService.findAll(pageable);
        List<AgHarvestedExifMetadataDTO> dtoList = agHarvestedExifMetadataPage
                .stream()
                .map(agHarvestedExifMetadataMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agHarvestedExifMetadataPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgHarvestedExifMetadataDTO update(@RequestBody AgHarvestedExifMetadataDTO agHarvestedExifMetadataDTO, @PathVariable("id") Long id) {
        AgHarvestedExifMetadata agHarvestedExifMetadata = agHarvestedExifMetadataMapper.asEntity(agHarvestedExifMetadataDTO);
        return agHarvestedExifMetadataMapper.asDTO(agHarvestedExifMetadataService.update(agHarvestedExifMetadata, id));
    }
}