package com.maliciamrg.lrjavaapi.service.impl;

import com.maliciamrg.lrjavaapi.dao.AgInternedExifCameraModelRepository;
import com.maliciamrg.lrjavaapi.dto.AgInternedExifCameraModelDTO;
import com.maliciamrg.lrjavaapi.mapper.AgInternedExifCameraModelMapper;
import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import com.maliciamrg.lrjavaapi.service.AgInternedExifCameraModelService;
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
public class AgInternedExifCameraModelServiceImpl implements AgInternedExifCameraModelService {
    private final AgInternedExifCameraModelRepository repository;

    public AgInternedExifCameraModelServiceImpl(AgInternedExifCameraModelRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgInternedExifCameraModel save(AgInternedExifCameraModel entity) {
        return repository.save(entity);
    }

    @Override
    public List<AgInternedExifCameraModel> save(List<AgInternedExifCameraModel> entities) {
        return (List<AgInternedExifCameraModel>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AgInternedExifCameraModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AgInternedExifCameraModel> findAll() {
        return (List<AgInternedExifCameraModel>) repository.findAll();
    }

    @Override
    public Page<AgInternedExifCameraModel> findAll(Pageable pageable) {
        Page<AgInternedExifCameraModel> entityPage = repository.findAll(pageable);
        List<AgInternedExifCameraModel> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public AgInternedExifCameraModel update(AgInternedExifCameraModel entity, Long id) {
        Optional<AgInternedExifCameraModel> optional = findById(id) ;
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}