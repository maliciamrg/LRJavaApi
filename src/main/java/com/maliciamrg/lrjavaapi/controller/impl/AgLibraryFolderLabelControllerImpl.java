package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryFolderLabelController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderLabelMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderLabelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-folder-label")
@RestController
public class AgLibraryFolderLabelControllerImpl implements AgLibraryFolderLabelController {
    private final AgLibraryFolderLabelService agLibraryFolderLabelService;
    private final AgLibraryFolderLabelMapper agLibraryFolderLabelMapper;

    public AgLibraryFolderLabelControllerImpl(AgLibraryFolderLabelService agLibraryFolderLabelService, AgLibraryFolderLabelMapper agLibraryFolderLabelMapper) {
        this.agLibraryFolderLabelService = agLibraryFolderLabelService;
        this.agLibraryFolderLabelMapper = agLibraryFolderLabelMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryFolderLabelDTO save(@RequestBody AgLibraryFolderLabelDTO agLibraryFolderLabelDTO) {
        AgLibraryFolderLabel agLibraryFolderLabel = agLibraryFolderLabelMapper.asEntity(agLibraryFolderLabelDTO);
        return agLibraryFolderLabelMapper.asDTO(agLibraryFolderLabelService.save(agLibraryFolderLabel));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryFolderLabelDTO findById(@PathVariable("id") Long id) {
        AgLibraryFolderLabel agLibraryFolderLabel = agLibraryFolderLabelService.findById(id).orElse(null);
        return agLibraryFolderLabelMapper.asDTO(agLibraryFolderLabel);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryFolderLabelService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryFolderLabelDTO> list() {
        return agLibraryFolderLabelMapper.asDTOList(agLibraryFolderLabelService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryFolderLabelDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryFolderLabel> agLibraryFolderLabelPage = agLibraryFolderLabelService.findAll(pageable);
        List<AgLibraryFolderLabelDTO> dtoList = agLibraryFolderLabelPage
                .stream()
                .map(agLibraryFolderLabelMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryFolderLabelPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryFolderLabelDTO update(@RequestBody AgLibraryFolderLabelDTO agLibraryFolderLabelDTO, @PathVariable("id") Long id) {
        AgLibraryFolderLabel agLibraryFolderLabel = agLibraryFolderLabelMapper.asEntity(agLibraryFolderLabelDTO);
        return agLibraryFolderLabelMapper.asDTO(agLibraryFolderLabelService.update(agLibraryFolderLabel, id));
    }
}