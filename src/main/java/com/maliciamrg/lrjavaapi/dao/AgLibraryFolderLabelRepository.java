package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgLibraryFolderLabel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgLibraryFolderLabelRepository extends PagingAndSortingRepository<AgLibraryFolderLabel, Long> {
}