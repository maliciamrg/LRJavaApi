package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryFolderRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderService;
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
public class AgLibraryFolderServiceImpl implements AgLibraryFolderService {
    private final AgLibraryFolderRepository repository;

    public AgLibraryFolderServiceImpl(AgLibraryFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryFolder save(AgLibraryFolder entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryFolder> save(List<AgLibraryFolder> entities) {
        return (List<AgLibraryFolder>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryFolder> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryFolder> findAll() {
        return (List<AgLibraryFolder>) repository.findAll();
    }

    @Override
    public Page<AgLibraryFolder> findAll(Pageable pageable) {
        Page<AgLibraryFolder> entityPage = repository.findAll(pageable);
        List<AgLibraryFolder> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryFolder update(AgLibraryFolder entity, Long id) {
        Optional<AgLibraryFolder> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}