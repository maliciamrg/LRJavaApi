package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryFolder")
public class AgLibraryFolder implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "id_global", unique = true, nullable = false)
    private Long idGlobal;
    @Column(name = "parentId")
    private Long parentId;
    @Column(name = "pathFromRoot", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String pathFromRoot;
    @Column(name = "rootFolder", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer rootFolder;
    @Column(name = "visibility")
    private Integer visibility;

    public AgLibraryFolder() {
    }

    public AgLibraryFolder(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    @Override
    public String toString() {
        return "AgLibraryFolder{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", parentId=" + parentId +
                ", pathFromRoot='" + pathFromRoot + '\'' +
                ", rootFolder=" + rootFolder +
                ", visibility=" + visibility +
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPathFromRoot() {
        return pathFromRoot;
    }

    public void setPathFromRoot(String pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }

    public Integer getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(Integer rootFolder) {
        this.rootFolder = rootFolder;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    // Add getters and setters
}
