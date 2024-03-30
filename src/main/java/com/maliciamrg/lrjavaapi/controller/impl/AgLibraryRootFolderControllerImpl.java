package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryRootFolderController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryRootFolderMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryRootFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-root-folder")
@RestController
public class AgLibraryRootFolderControllerImpl implements AgLibraryRootFolderController {

    private final AgLibraryRootFolderService agLibraryRootFolderService;
    private final AgLibraryRootFolderMapper agLibraryRootFolderMapper;

    public AgLibraryRootFolderControllerImpl(AgLibraryRootFolderService agLibraryRootFolderService, AgLibraryRootFolderMapper agLibraryRootFolderMapper) {
        this.agLibraryRootFolderService = agLibraryRootFolderService;
        this.agLibraryRootFolderMapper = agLibraryRootFolderMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryRootFolderDTO save(@RequestBody AgLibraryRootFolderDTO agLibraryRootFolderDTO) {
        AgLibraryRootFolder agLibraryRootFolder = agLibraryRootFolderMapper.asEntity(agLibraryRootFolderDTO);
        return agLibraryRootFolderMapper.asDTO(agLibraryRootFolderService.save(agLibraryRootFolder));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryRootFolderDTO findById(@PathVariable("id") Long id) {
        AgLibraryRootFolder agLibraryRootFolder = agLibraryRootFolderService.findById(id).orElse(null);
        return agLibraryRootFolderMapper.asDTO(agLibraryRootFolder);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryRootFolderService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryRootFolderDTO> list() {
        return agLibraryRootFolderMapper.asDTOList(agLibraryRootFolderService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryRootFolderDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryRootFolder> agLibraryRootFolderPage = agLibraryRootFolderService.findAll(pageable);
        List<AgLibraryRootFolderDTO> dtoList = agLibraryRootFolderPage
                .stream()
                .map(agLibraryRootFolderMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryRootFolderPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryRootFolderDTO update(@RequestBody AgLibraryRootFolderDTO agLibraryRootFolderDTO, @PathVariable("id") Long id) {
        AgLibraryRootFolder agLibraryRootFolder = agLibraryRootFolderMapper.asEntity(agLibraryRootFolderDTO);
        return agLibraryRootFolderMapper.asDTO(agLibraryRootFolderService.update(agLibraryRootFolder, id));
    }
}