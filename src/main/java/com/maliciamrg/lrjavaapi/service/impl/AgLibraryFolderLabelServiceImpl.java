package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryFolderLabelRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryFolderLabelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryFolderLabelMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import com.maliciamrg.lrjavaapi.service.AgLibraryFolderLabelService;
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
public class AgLibraryFolderLabelServiceImpl implements AgLibraryFolderLabelService {
    private final AgLibraryFolderLabelRepository repository;

    public AgLibraryFolderLabelServiceImpl(AgLibraryFolderLabelRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryFolderLabel save(AgLibraryFolderLabel entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryFolderLabel> save(List<AgLibraryFolderLabel> entities) {
        return (List<AgLibraryFolderLabel>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryFolderLabel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryFolderLabel> findAll() {
        return (List<AgLibraryFolderLabel>) repository.findAll();
    }

    @Override
    public Page<AgLibraryFolderLabel> findAll(Pageable pageable) {
        Page<AgLibraryFolderLabel> entityPage = repository.findAll(pageable);
        List<AgLibraryFolderLabel> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryFolderLabel update(AgLibraryFolderLabel entity, Long id) {
        Optional<AgLibraryFolderLabel> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}