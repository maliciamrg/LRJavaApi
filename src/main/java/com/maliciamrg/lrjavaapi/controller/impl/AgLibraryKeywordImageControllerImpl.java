package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryKeywordImageController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordImageMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-keyword-image")
@RestController
public class AgLibraryKeywordImageControllerImpl implements AgLibraryKeywordImageController {
    private final AgLibraryKeywordImageService agLibraryKeywordImageService;
    private final AgLibraryKeywordImageMapper agLibraryKeywordImageMapper;

    public AgLibraryKeywordImageControllerImpl(AgLibraryKeywordImageService agLibraryKeywordImageService, AgLibraryKeywordImageMapper agLibraryKeywordImageMapper) {
        this.agLibraryKeywordImageService = agLibraryKeywordImageService;
        this.agLibraryKeywordImageMapper = agLibraryKeywordImageMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryKeywordImageDTO save(@RequestBody AgLibraryKeywordImageDTO agLibraryKeywordImageDTO) {
        AgLibraryKeywordImage agLibraryKeywordImage = agLibraryKeywordImageMapper.asEntity(agLibraryKeywordImageDTO);
        return agLibraryKeywordImageMapper.asDTO(agLibraryKeywordImageService.save(agLibraryKeywordImage));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryKeywordImageDTO findById(@PathVariable("id") Long id) {
        AgLibraryKeywordImage agLibraryKeywordImage = agLibraryKeywordImageService.findById(id).orElse(null);
        return agLibraryKeywordImageMapper.asDTO(agLibraryKeywordImage);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryKeywordImageService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryKeywordImageDTO> list() {
        return agLibraryKeywordImageMapper.asDTOList(agLibraryKeywordImageService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryKeywordImageDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryKeywordImage> agLibraryKeywordImagePage = agLibraryKeywordImageService.findAll(pageable);
        List<AgLibraryKeywordImageDTO> dtoList = agLibraryKeywordImagePage
                .stream()
                .map(agLibraryKeywordImageMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryKeywordImagePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryKeywordImageDTO update(@RequestBody AgLibraryKeywordImageDTO agLibraryKeywordImageDTO, @PathVariable("id") Long id) {
        AgLibraryKeywordImage agLibraryKeywordImage = agLibraryKeywordImageMapper.asEntity(agLibraryKeywordImageDTO);
        return agLibraryKeywordImageMapper.asDTO(agLibraryKeywordImageService.update(agLibraryKeywordImage, id));
    }
}