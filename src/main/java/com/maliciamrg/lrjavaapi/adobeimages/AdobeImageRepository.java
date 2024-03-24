package com.maliciamrg.lrjavaapi.adobeimages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdobeImageRepository extends JpaRepository<AdobeImages, Integer> {
    AdobeImages findByIdLocal(Integer idLocal);

    Optional<AdobeImages> findByIdLocalOrIdGlobal(Integer idLocal, String idGlobal);

    void deleteByIdLocal(Integer idLocal);

    boolean existsByIdGlobal(String idGlobal);

    void deleteByIdGlobal(String idGlobal);

    Optional<AdobeImages> findByIdGlobal(String idGlobal);

}