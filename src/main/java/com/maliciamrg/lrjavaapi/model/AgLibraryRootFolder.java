package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryRootFolder")
public class AgLibraryRootFolder implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "id_global", unique = true, nullable = false)
    private Long idGlobal;
    @Column(name = "absolutePath", unique = true, nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String absolutePath;
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String name;
    @Column(name = "relativePathFromCatalog")
    private String relativePathFromCatalog;

    public AgLibraryRootFolder(Long idLocal, Long idGlobal, String absolutePath, String name, String relativePathFromCatalog) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.absolutePath = absolutePath;
        this.name = name;
        this.relativePathFromCatalog = relativePathFromCatalog;
    }

    @Override
    public String toString() {
        return "AgLibraryRootFolder{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", absolutePath='" + absolutePath + '\'' +
                ", name='" + name + '\'' +
                ", relativePathFromCatalog='" + relativePathFromCatalog + '\'' +
                '}';
    }

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(Long idGlobal) {
        this.idGlobal = idGlobal;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelativePathFromCatalog() {
        return relativePathFromCatalog;
    }

    public void setRelativePathFromCatalog(String relativePathFromCatalog) {
        this.relativePathFromCatalog = relativePathFromCatalog;
    }

    // Add getters and setters
}
