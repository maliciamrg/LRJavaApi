package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryFolderController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-folder")
@RestController
public class AgLibraryFolderControllerImpl implements AgLibraryFolderController {
    private final AgLibraryFolderService agLibraryFolderService;
    private final AgLibraryFolderMapper agLibraryFolderMapper;

    public AgLibraryFolderControllerImpl(AgLibraryFolderService agLibraryFolderService, AgLibraryFolderMapper agLibraryFolderMapper) {
        this.agLibraryFolderService = agLibraryFolderService;
        this.agLibraryFolderMapper = agLibraryFolderMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryFolderDTO save(@RequestBody AgLibraryFolderDTO agLibraryFolderDTO) {
        AgLibraryFolder agLibraryFolder = agLibraryFolderMapper.asEntity(agLibraryFolderDTO);
        return agLibraryFolderMapper.asDTO(agLibraryFolderService.save(agLibraryFolder));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryFolderDTO findById(@PathVariable("id") Long id) {
        AgLibraryFolder agLibraryFolder = agLibraryFolderService.findById(id).orElse(null);
        return agLibraryFolderMapper.asDTO(agLibraryFolder);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryFolderService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryFolderDTO> list() {
        return agLibraryFolderMapper.asDTOList(agLibraryFolderService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryFolderDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryFolder> agLibraryFolderPage = agLibraryFolderService.findAll(pageable);
        List<AgLibraryFolderDTO> dtoList = agLibraryFolderPage
                .stream()
                .map(agLibraryFolderMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryFolderPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryFolderDTO update(@RequestBody AgLibraryFolderDTO agLibraryFolderDTO, @PathVariable("id") Long id) {
        AgLibraryFolder agLibraryFolder = agLibraryFolderMapper.asEntity(agLibraryFolderDTO);
        return agLibraryFolderMapper.asDTO(agLibraryFolderService.update(agLibraryFolder, id));
    }
}