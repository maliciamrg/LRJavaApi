package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AdobeImagesRepository;
import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import com.maliciamrg.lrjavaapi.dto.AdobeImagesDTO;
import com.maliciamrg.lrjavaapi.mapper.AdobeImagesMapper;
import com.maliciamrg.lrjavaapi.service.AdobeImagesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdobeImagesServiceImpl implements AdobeImagesService {
    private final AdobeImagesRepository repository;

    public AdobeImagesServiceImpl(AdobeImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public AdobeImages save(AdobeImages entity) {
        return repository.save(entity);
    }

    @Override
    public List<AdobeImages> save(List<AdobeImages> entities) {
        return (List<AdobeImages>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AdobeImages> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<AdobeImages> findAll() {
        return (List<AdobeImages>) repository.findAll();
    }

    @Override
    public Page<AdobeImages> findAll(Pageable pageable) {
        Page<AdobeImages> entityPage = repository.findAll(pageable);
        List<AdobeImages> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AdobeImages update(AdobeImages entity, Integer id) {
        Optional<AdobeImages> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}