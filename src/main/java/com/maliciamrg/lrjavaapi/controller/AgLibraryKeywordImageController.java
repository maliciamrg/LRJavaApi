package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryKeywordImage API")
public interface AgLibraryKeywordImageController {
    @ApiOperation("Add new data")
    public AgLibraryKeywordImageDTO save(@RequestBody AgLibraryKeywordImageDTO agLibraryKeywordImage);

    @ApiOperation("Find by Id")
    public AgLibraryKeywordImageDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryKeywordImageDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryKeywordImageDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryKeywordImageDTO update(@RequestBody AgLibraryKeywordImageDTO dto, @PathVariable("id") Long id);
}