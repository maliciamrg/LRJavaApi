package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryFolder API")
public interface AgLibraryFolderController {
    @ApiOperation("Add new data")
    public AgLibraryFolderDTO save(@RequestBody AgLibraryFolderDTO agLibraryFolder);

    @ApiOperation("Find by Id")
    public AgLibraryFolderDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryFolderDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryFolderDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryFolderDTO update(@RequestBody AgLibraryFolderDTO dto, @PathVariable("id") Long id);
}