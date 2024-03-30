package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgHarvestedExifMetadata;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgHarvestedExifMetadataRepository extends PagingAndSortingRepository<AgHarvestedExifMetadata, Long> {
}