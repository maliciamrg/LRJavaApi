package com.maliciamrg.lrjavaapi.controller;

import com.maliciamrg.lrjavaapi.dto.AdobeImagesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AdobeImages API")
public interface AdobeImagesController {
    @ApiOperation("Add new data")
    public AdobeImagesDTO save(@RequestBody AdobeImagesDTO adobeImages);

    @ApiOperation("Find by Id")
    public AdobeImagesDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<AdobeImagesDTO> list();

    @ApiOperation("Pagination request")
    public Page<AdobeImagesDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AdobeImagesDTO update(@RequestBody AdobeImagesDTO dto, @PathVariable("id") Integer id);
}