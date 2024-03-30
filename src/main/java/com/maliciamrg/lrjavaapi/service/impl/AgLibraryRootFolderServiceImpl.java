package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryRootFolderRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryRootFolderDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryRootFolderMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;
import com.maliciamrg.lrjavaapi.service.AgLibraryRootFolderService;
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
public class AgLibraryRootFolderServiceImpl implements AgLibraryRootFolderService {
    private final AgLibraryRootFolderRepository repository;

    public AgLibraryRootFolderServiceImpl(AgLibraryRootFolderRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryRootFolder save(AgLibraryRootFolder entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryRootFolder> save(List<AgLibraryRootFolder> entities) {
        return (List<AgLibraryRootFolder>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryRootFolder> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryRootFolder> findAll() {
        return (List<AgLibraryRootFolder>) repository.findAll();
    }

    @Override
    public Page<AgLibraryRootFolder> findAll(Pageable pageable) {
        Page<AgLibraryRootFolder> entityPage = repository.findAll(pageable);
        List<AgLibraryRootFolder> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryRootFolder update(AgLibraryRootFolder entity, Long id) {
        Optional<AgLibraryRootFolder> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}