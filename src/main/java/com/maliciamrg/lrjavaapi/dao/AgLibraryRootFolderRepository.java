package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.model.AgLibraryRootFolder;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgLibraryRootFolderRepository extends PagingAndSortingRepository<AgLibraryRootFolder, Long> {
}