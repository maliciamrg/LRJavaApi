package com.maliciamrg.lrcat.controller;


import com.maliciamrg.lrcat.model.AgLibraryFile;
import com.maliciamrg.lrcat.service.AgLibraryFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agLibraryFile")
public class AgLibraryFileController {


    @Autowired
    private AgLibraryFileService agLibraryFileService;

    @GetMapping
    public List<AgLibraryFile> getAllAgLibraryFiles() {
        return agLibraryFileService.getAllAgLibraryFiles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgLibraryFile> getAgLibraryFileById(@PathVariable Long id) {
        AgLibraryFile user = agLibraryFileService.getAgLibraryFileById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AgLibraryFile createAgLibraryFile(@RequestBody AgLibraryFile agLibraryFile) {
        return agLibraryFileService.createAgLibraryFile(agLibraryFile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgLibraryFile> updateAgLibraryFile(@PathVariable Long id, @RequestBody AgLibraryFile agLibraryFileDetails) {
        AgLibraryFile updatedAgLibraryFile = agLibraryFileService.updateAgLibraryFile(id, agLibraryFileDetails);
        if (updatedAgLibraryFile != null) {
            return ResponseEntity.ok(updatedAgLibraryFile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgLibraryFile(@PathVariable Long id) {
        agLibraryFileService.deleteAgLibraryFile(id);
        return ResponseEntity.noContent().build();
    }
}

