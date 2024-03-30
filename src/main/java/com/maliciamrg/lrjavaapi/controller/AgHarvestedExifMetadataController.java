package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AgHarvestedExifMetadata API")
public interface AgHarvestedExifMetadataController {
    @ApiOperation("Add new data")
    public AgHarvestedExifMetadataDTO save(@RequestBody AgHarvestedExifMetadataDTO agHarvestedExifMetadata);

    @ApiOperation("Find by Id")
    public AgHarvestedExifMetadataDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AgHarvestedExifMetadataDTO> list();

    @ApiOperation("Pagination request")
    public Page<AgHarvestedExifMetadataDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AgHarvestedExifMetadataDTO update(@RequestBody AgHarvestedExifMetadataDTO dto, @PathVariable("id") Long id);
}