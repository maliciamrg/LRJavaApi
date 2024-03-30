package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryRootFolderDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long idGlobal;
    private String absolutePath;
    private String name;
    private String relativePathFromCatalog;

    public AgLibraryRootFolderDTO() {
    }

    public AgLibraryRootFolderDTO(long idLocal, long idGlobal, String absolutePath, String name, String relativePathFromCatalog) {
        super();
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.absolutePath = absolutePath;
        this.name = name;
        this.relativePathFromCatalog = relativePathFromCatalog;
    }

    public Long getIdLocal() {
        return this.idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdGlobal() {
        return this.idGlobal;
    }

    public void setIdGlobal(Long idGlobal) {
        this.idGlobal = idGlobal;
    }

    public String getAbsolutePath() {
        return this.absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelativePathFromCatalog() {
        return this.relativePathFromCatalog;
    }

    public void setRelativePathFromCatalog(String relativePathFromCatalog) {
        this.relativePathFromCatalog = relativePathFromCatalog;
    }
}