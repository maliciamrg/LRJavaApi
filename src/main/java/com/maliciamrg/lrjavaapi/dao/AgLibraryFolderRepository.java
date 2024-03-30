package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgLibraryFolder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgLibraryFolderRepository extends PagingAndSortingRepository<AgLibraryFolder, Long> {
}