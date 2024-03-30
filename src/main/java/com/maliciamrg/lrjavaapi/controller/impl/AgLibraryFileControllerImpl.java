package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryFileController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFileMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFile;
import com.maliciamrg.lrjavaapi.service.AgLibraryFileService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-file")
@RestController
public class AgLibraryFileControllerImpl implements AgLibraryFileController {
    private final AgLibraryFileService agLibraryFileService;
    private final AgLibraryFileMapper agLibraryFileMapper;

    public AgLibraryFileControllerImpl(AgLibraryFileService agLibraryFileService, AgLibraryFileMapper agLibraryFileMapper) {
        this.agLibraryFileService = agLibraryFileService;
        this.agLibraryFileMapper = agLibraryFileMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryFileDTO save(@RequestBody AgLibraryFileDTO agLibraryFileDTO) {
        AgLibraryFile agLibraryFile = agLibraryFileMapper.asEntity(agLibraryFileDTO);
        return agLibraryFileMapper.asDTO(agLibraryFileService.save(agLibraryFile));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryFileDTO findById(@PathVariable("id") Long id) {
        AgLibraryFile agLibraryFile = agLibraryFileService.findById(id).orElse(null);
        return agLibraryFileMapper.asDTO(agLibraryFile);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryFileService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryFileDTO> list() {
        return agLibraryFileMapper.asDTOList(agLibraryFileService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryFileDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryFile> agLibraryFilePage = agLibraryFileService.findAll(pageable);
        List<AgLibraryFileDTO> dtoList = agLibraryFilePage
                .stream()
                .map(agLibraryFileMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryFilePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryFileDTO update(@RequestBody AgLibraryFileDTO agLibraryFileDTO, @PathVariable("id") Long id) {
        AgLibraryFile agLibraryFile = agLibraryFileMapper.asEntity(agLibraryFileDTO);
        return agLibraryFileMapper.asDTO(agLibraryFileService.update(agLibraryFile, id));
    }
}