package com.maliciamrg.lrcat.service;

import com.maliciamrg.lrcat.model.AgLibraryFile;
import com.maliciamrg.lrcat.repository.AgLibraryFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgLibraryFileService {

    @Autowired
    private AgLibraryFileRepository AgLibraryFileRepository;

    public List<AgLibraryFile> getAllAgLibraryFiles() {
        return AgLibraryFileRepository.findAll();
    }

    public AgLibraryFile getAgLibraryFileById(Long id) {
        return AgLibraryFileRepository.findById(id).orElse(null);
    }

    public AgLibraryFile createAgLibraryFile(AgLibraryFile agLibraryFile) {
        return AgLibraryFileRepository.save(agLibraryFile);
    }

    public AgLibraryFile updateAgLibraryFile(Long id, AgLibraryFile agLibraryFileDetails) {
        AgLibraryFile agLibraryFile = AgLibraryFileRepository.findById(id).orElse(null);
        if (agLibraryFile != null) {
            agLibraryFile.setBaseName(agLibraryFileDetails.getBaseName());
            return AgLibraryFileRepository.save(agLibraryFile);
        }
        return null;
    }

    public void deleteAgLibraryFile(Long id) {
        AgLibraryFileRepository.deleteById(id);
    }
}
