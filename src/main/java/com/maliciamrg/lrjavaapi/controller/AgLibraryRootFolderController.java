package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryRootFolder API")
public interface AgLibraryRootFolderController {
    @ApiOperation("Add new data")
    public AgLibraryRootFolderDTO save(@RequestBody AgLibraryRootFolderDTO agLibraryRootFolder);

    @ApiOperation("Find by Id")
    public AgLibraryRootFolderDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryRootFolderDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryRootFolderDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryRootFolderDTO update(@RequestBody AgLibraryRootFolderDTO dto, @PathVariable("id") Long id);
}