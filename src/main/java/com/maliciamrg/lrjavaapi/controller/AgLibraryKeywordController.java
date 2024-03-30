package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgLibraryKeyword API")
public interface AgLibraryKeywordController {
    @ApiOperation("Add new data")
    public AgLibraryKeywordDTO save(@RequestBody AgLibraryKeywordDTO agLibraryKeyword);

    @ApiOperation("Find by Id")
    public AgLibraryKeywordDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgLibraryKeywordDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgLibraryKeywordDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgLibraryKeywordDTO update(@RequestBody AgLibraryKeywordDTO dto, @PathVariable("id") Long id);
}