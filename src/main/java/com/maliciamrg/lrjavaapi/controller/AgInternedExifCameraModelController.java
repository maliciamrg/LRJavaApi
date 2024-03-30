package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgInternedExifCameraModel API")
public interface AgInternedExifCameraModelController {
    @ApiOperation("Add new data")
    public AgInternedExifCameraModelDTO save(@RequestBody AgInternedExifCameraModelDTO agInternedExifCameraModel);

    @ApiOperation("Find by Id")
    public AgInternedExifCameraModelDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgInternedExifCameraModelDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgInternedExifCameraModelDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgInternedExifCameraModelDTO update(@RequestBody AgInternedExifCameraModelDTO dto, @PathVariable("id") Long id);
}