package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgHarvestedExifMetadataRepository;
import com.maliciamrg.lrjavaapi.dto.AgHarvestedExifMetadataDTO;
import com.maliciamrg.lrjavaapi.mapper.AgHarvestedExifMetadataMapper;
import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import com.maliciamrg.lrjavaapi.service.AgHarvestedExifMetadataService;
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
public class AgHarvestedExifMetadataServiceImpl implements AgHarvestedExifMetadataService {
    private final AgHarvestedExifMetadataRepository repository;

    public AgHarvestedExifMetadataServiceImpl(AgHarvestedExifMetadataRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgHarvestedExifMetadata save(AgHarvestedExifMetadata entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgHarvestedExifMetadata> save(List<AgHarvestedExifMetadata> entities) {
        return (List<AgHarvestedExifMetadata>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgHarvestedExifMetadata> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgHarvestedExifMetadata> findAll() {
        return (List<AgHarvestedExifMetadata>) repository.findAll();
    }

    @Override
    public Page<AgHarvestedExifMetadata> findAll(Pageable pageable) {
        Page<AgHarvestedExifMetadata> entityPage = repository.findAll(pageable);
        List<AgHarvestedExifMetadata> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgHarvestedExifMetadata update(AgHarvestedExifMetadata entity, Long id) {
        Optional<AgHarvestedExifMetadata> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}