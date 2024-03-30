package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgLibraryKeywordRepository;
import com.maliciamrg.lrjavaapi.dto.AgLibraryKeywordDTO;
import com.maliciamrg.lrjavaapi.mapper.AgLibraryKeywordMapper;
import com.maliciamrg.lrjavaapi.model.AgLibraryKeyword;
import com.maliciamrg.lrjavaapi.service.AgLibraryKeywordService;
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
public class AgLibraryKeywordServiceImpl implements AgLibraryKeywordService {
    private final AgLibraryKeywordRepository repository;

    public AgLibraryKeywordServiceImpl(AgLibraryKeywordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgLibraryKeyword save(AgLibraryKeyword entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgLibraryKeyword> save(List<AgLibraryKeyword> entities) {
        return (List<AgLibraryKeyword>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgLibraryKeyword> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgLibraryKeyword> findAll() {
        return (List<AgLibraryKeyword>) repository.findAll();
    }

    @Override
    public Page<AgLibraryKeyword> findAll(Pageable pageable) {
        Page<AgLibraryKeyword> entityPage = repository.findAll(pageable);
        List<AgLibraryKeyword> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgLibraryKeyword update(AgLibraryKeyword entity, Long id) {
        Optional<AgLibraryKeyword> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}