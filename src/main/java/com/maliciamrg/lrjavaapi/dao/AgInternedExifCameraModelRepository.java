package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgInternedExifCameraModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgInternedExifCameraModelRepository extends PagingAndSortingRepository<AgInternedExifCameraModel, Long> {
}