package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryFileRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFileDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFileMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFile;
import com.maliciamrg.lrjavaapi.service.AgLibraryFileService;
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
public class AgLibraryFileServiceImpl implements AgLibraryFileService {
    private final AgLibraryFileRepository repository;

    public AgLibraryFileServiceImpl(AgLibraryFileRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryFile save(AgLibraryFile entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryFile> save(List<AgLibraryFile> entities) {
        return (List<AgLibraryFile>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryFile> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryFile> findAll() {
        return (List<AgLibraryFile>) repository.findAll();
    }

    @Override
    public Page<AgLibraryFile> findAll(Pageable pageable) {
        Page<AgLibraryFile> entityPage = repository.findAll(pageable);
        List<AgLibraryFile> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryFile update(AgLibraryFile entity, Long id) {
        Optional<AgLibraryFile> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}