package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgInternedExifCameraModelController;
import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgInternedExifCameraModelMapper;
import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import com.maliciamrg.lrjavaapi.service.AgInternedExifCameraModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-interned-exif-camera-model")
@RestController
public class AgInternedExifCameraModelControllerImpl implements AgInternedExifCameraModelController {
    private final AgInternedExifCameraModelService agInternedExifCameraModelService;
    private final AgInternedExifCameraModelMapper agInternedExifCameraModelMapper;

    public AgInternedExifCameraModelControllerImpl(AgInternedExifCameraModelService agInternedExifCameraModelService, AgInternedExifCameraModelMapper agInternedExifCameraModelMapper) {
        this.agInternedExifCameraModelService = agInternedExifCameraModelService;
        this.agInternedExifCameraModelMapper = agInternedExifCameraModelMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgInternedExifCameraModelDTO save(@RequestBody AgInternedExifCameraModelDTO agInternedExifCameraModelDTO) {
        AgInternedExifCameraModel agInternedExifCameraModel = agInternedExifCameraModelMapper.asEntity(agInternedExifCameraModelDTO);
        return agInternedExifCameraModelMapper.asDTO(agInternedExifCameraModelService.save(agInternedExifCameraModel));
    }

    @Override
    @GetMapping("/{id}")
    public AgInternedExifCameraModelDTO findById(@PathVariable("id") Long id) {
        AgInternedExifCameraModel agInternedExifCameraModel = agInternedExifCameraModelService.findById(id).orElse(null);
        return agInternedExifCameraModelMapper.asDTO(agInternedExifCameraModel);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agInternedExifCameraModelService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgInternedExifCameraModelDTO> list() {
        return agInternedExifCameraModelMapper.asDTOList(agInternedExifCameraModelService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgInternedExifCameraModelDTO> pageQuery(Pageable pageable) {
        Page<AgInternedExifCameraModel> agInternedExifCameraModelPage = agInternedExifCameraModelService.findAll(pageable);
        List<AgInternedExifCameraModelDTO> dtoList = agInternedExifCameraModelPage
                .stream()
                .map(agInternedExifCameraModelMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agInternedExifCameraModelPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgInternedExifCameraModelDTO update(@RequestBody AgInternedExifCameraModelDTO agInternedExifCameraModelDTO, @PathVariable("id") Long id) {
        AgInternedExifCameraModel agInternedExifCameraModel = agInternedExifCameraModelMapper.asEntity(agInternedExifCameraModelDTO);
        return agInternedExifCameraModelMapper.asDTO(agInternedExifCameraModelService.update(agInternedExifCameraModel, id));
    }
}