package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryKeywordImageRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordImageDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordImageMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordImageService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgLibraryKeywordImageServiceImpl implements AgLibraryKeywordImageService {
    private final AgLibraryKeywordImageRepository repository;

    public AgLibraryKeywordImageServiceImpl(AgLibraryKeywordImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryKeywordImage save(AgLibraryKeywordImage entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryKeywordImage> save(List<AgLibraryKeywordImage> entities) {
        return (List<AgLibraryKeywordImage>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryKeywordImage> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryKeywordImage> findAll() {
        return (List<AgLibraryKeywordImage>) repository.findAll();
    }

    @Override
    public Page<AgLibraryKeywordImage> findAll(Pageable pageable) {
        Page<AgLibraryKeywordImage> entityPage = repository.findAll(pageable);
        List<AgLibraryKeywordImage> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryKeywordImage update(AgLibraryKeywordImage entity, Long id) {
        Optional<AgLibraryKeywordImage> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}