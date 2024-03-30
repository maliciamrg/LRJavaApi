package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryFile API")
public interface AgLibraryFileController {
    @ApiOperation("Add new data")
    public AgLibraryFileDTO save(@RequestBody AgLibraryFileDTO agLibraryFile);

    @ApiOperation("Find by Id")
    public AgLibraryFileDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryFileDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryFileDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryFileDTO update(@RequestBody AgLibraryFileDTO dto, @PathVariable("id") Long id);
}