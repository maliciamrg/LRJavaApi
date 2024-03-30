package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgLibraryKeywordImage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgLibraryKeywordImageRepository extends PagingAndSortingRepository<AgLibraryKeywordImage, Long> {
}