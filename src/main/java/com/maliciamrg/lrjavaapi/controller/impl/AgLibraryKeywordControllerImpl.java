package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AgLibraryKeywordController;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/ag-library-keyword")
@RestController
public class AgLibraryKeywordControllerImpl implements AgLibraryKeywordController {
    private final AgLibraryKeywordService agLibraryKeywordService;
    private final AgLibraryKeywordMapper agLibraryKeywordMapper;

    public AgLibraryKeywordControllerImpl(AgLibraryKeywordService agLibraryKeywordService, AgLibraryKeywordMapper agLibraryKeywordMapper) {
        this.agLibraryKeywordService = agLibraryKeywordService;
        this.agLibraryKeywordMapper = agLibraryKeywordMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgLibraryKeywordDTO save(@RequestBody AgLibraryKeywordDTO agLibraryKeywordDTO) {
        AgLibraryKeyword agLibraryKeyword = agLibraryKeywordMapper.asEntity(agLibraryKeywordDTO);
        return agLibraryKeywordMapper.asDTO(agLibraryKeywordService.save(agLibraryKeyword));
    }

    @Override
    @GetMapping("/{id}")
    public AgLibraryKeywordDTO findById(@PathVariable("id") Long id) {
        AgLibraryKeyword agLibraryKeyword = agLibraryKeywordService.findById(id).orElse(null);
        return agLibraryKeywordMapper.asDTO(agLibraryKeyword);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        agLibraryKeywordService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AgLibraryKeywordDTO> list() {
        return agLibraryKeywordMapper.asDTOList(agLibraryKeywordService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AgLibraryKeywordDTO> pageQuery(Pageable pageable) {
        Page<AgLibraryKeyword> agLibraryKeywordPage = agLibraryKeywordService.findAll(pageable);
        List<AgLibraryKeywordDTO> dtoList = agLibraryKeywordPage
                .stream()
                .map(agLibraryKeywordMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, agLibraryKeywordPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AgLibraryKeywordDTO update(@RequestBody AgLibraryKeywordDTO agLibraryKeywordDTO, @PathVariable("id") Long id) {
        AgLibraryKeyword agLibraryKeyword = agLibraryKeywordMapper.asEntity(agLibraryKeywordDTO);
        return agLibraryKeywordMapper.asDTO(agLibraryKeywordService.update(agLibraryKeyword, id));
    }
}