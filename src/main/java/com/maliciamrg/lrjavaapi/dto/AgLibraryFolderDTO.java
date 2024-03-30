package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryFolderDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long idGlobal;
    private Long parentId;
    private String pathFromRoot;
    private Integer rootFolder;
    private Integer visibility;

    public AgLibraryFolderDTO(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    public AgLibraryFolderDTO() {
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdLocal() {
        return this.idLocal;
    }

    public void setIdGlobal(Long idGlobal) {
        this.idGlobal = idGlobal;
    }

    public Long getIdGlobal() {
        return this.idGlobal;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setPathFromRoot(String pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }

    public String getPathFromRoot() {
        return this.pathFromRoot;
    }

    public void setRootFolder(Integer rootFolder) {
        this.rootFolder = rootFolder;
    }

    public Integer getRootFolder() {
        return this.rootFolder;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getVisibility() {
        return this.visibility;
    }
}