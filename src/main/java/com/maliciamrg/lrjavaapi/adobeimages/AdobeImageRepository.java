package com.maliciamrg.lrjavaapi.adobeimages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdobeImageRepository extends JpaRepository<AdobeImages, Integer> {

}