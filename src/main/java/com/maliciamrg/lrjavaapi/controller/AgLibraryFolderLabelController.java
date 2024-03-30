package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryFolderLabel API")
public interface AgLibraryFolderLabelController {
    @ApiOperation("Add new data")
    public AgLibraryFolderLabelDTO save(@RequestBody AgLibraryFolderLabelDTO agLibraryFolderLabel);

    @ApiOperation("Find by Id")
    public AgLibraryFolderLabelDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryFolderLabelDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryFolderLabelDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryFolderLabelDTO update(@RequestBody AgLibraryFolderLabelDTO dto, @PathVariable("id") Long id);
}