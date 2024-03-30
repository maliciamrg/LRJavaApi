package com.maliciamrg.lrjavaapi.dao;

import com.maliciamrg.lrjavaapi.adobeimages.AdobeImages;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdobeImagesRepository extends PagingAndSortingRepository<AdobeImages, Integer> {
}