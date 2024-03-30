package com.maliciamrg.lrjavaapi.controller.impl;

import com.maliciamrg.lrjavaapi.controller.AdobeImagesController;
import com.maliciamrg.lrjavaapi.dto.AdobeImagesDTO;
import com.maliciamrg.lrjavaapi.mapper.AdobeImagesMapper;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import com.maliciamrg.lrjavaapi.service.AdobeImagesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/adobe-images")
@RestController
public class AdobeImagesControllerImpl implements AdobeImagesController {
    private final AdobeImagesService adobeImagesService;
    private final AdobeImagesMapper adobeImagesMapper;

    public AdobeImagesControllerImpl(AdobeImagesService adobeImagesService, AdobeImagesMapper adobeImagesMapper) {
        this.adobeImagesService = adobeImagesService;
        this.adobeImagesMapper = adobeImagesMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdobeImagesDTO save(@RequestBody AdobeImagesDTO adobeImagesDTO) {
        AdobeImages adobeImages = adobeImagesMapper.asEntity(adobeImagesDTO);
        return adobeImagesMapper.asDTO(adobeImagesService.save(adobeImages));
    }

    @Override
    @GetMapping("/{id}")
    public AdobeImagesDTO findById(@PathVariable("id") Integer id) {
        AdobeImages adobeImages = adobeImagesService.findById(id).orElse(null);
        return adobeImagesMapper.asDTO(adobeImages);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        adobeImagesService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<AdobeImagesDTO> list() {
        return adobeImagesMapper.asDTOList(adobeImagesService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<AdobeImagesDTO> pageQuery(Pageable pageable) {
        Page<AdobeImages> adobeImagesPage = adobeImagesService.findAll(pageable);
        List<AdobeImagesDTO> dtoList = adobeImagesPage
                .stream()
                .map(adobeImagesMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, adobeImagesPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public AdobeImagesDTO update(@RequestBody AdobeImagesDTO adobeImagesDTO, @PathVariable("id") Integer id) {
        AdobeImages adobeImages = adobeImagesMapper.asEntity(adobeImagesDTO);
        return adobeImagesMapper.asDTO(adobeImagesService.update(adobeImages, id));
    }
}