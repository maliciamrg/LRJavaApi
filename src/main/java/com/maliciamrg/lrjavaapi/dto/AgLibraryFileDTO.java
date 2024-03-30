package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryFileDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long idGlobal;
    private String baseName;
    private String errorMessage;
    private Long errorTime;
    private String extension;
    private Long externalModTime;
    private Integer folder;
    private String idxFilename;
    private String importHash;
    private String lcIdxFilename;
    private String lcIdxFilenameExtension;
    private String md5;
    private Long modTime;
    private String originalFilename;
    private String sidecarExtensions;

    public AgLibraryFileDTO() {
    }

    public AgLibraryFileDTO(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
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

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseName() {
        return this.baseName;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorTime(Long errorTime) {
        this.errorTime = errorTime;
    }

    public Long getErrorTime() {
        return this.errorTime;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExternalModTime(Long externalModTime) {
        this.externalModTime = externalModTime;
    }

    public Long getExternalModTime() {
        return this.externalModTime;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public Integer getFolder() {
        return this.folder;
    }

    public void setIdxFilename(String idxFilename) {
        this.idxFilename = idxFilename;
    }

    public String getIdxFilename() {
        return this.idxFilename;
    }

    public void setImportHash(String importHash) {
        this.importHash = importHash;
    }

    public String getImportHash() {
        return this.importHash;
    }

    public void setLcIdxFilename(String lcIdxFilename) {
        this.lcIdxFilename = lcIdxFilename;
    }

    public String getLcIdxFilename() {
        return this.lcIdxFilename;
    }

    public void setLcIdxFilenameExtension(String lcIdxFilenameExtension) {
        this.lcIdxFilenameExtension = lcIdxFilenameExtension;
    }

    public String getLcIdxFilenameExtension() {
        return this.lcIdxFilenameExtension;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setModTime(Long modTime) {
        this.modTime = modTime;
    }

    public Long getModTime() {
        return this.modTime;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public void setSidecarExtensions(String sidecarExtensions) {
        this.sidecarExtensions = sidecarExtensions;
    }

    public String getSidecarExtensions() {
        return this.sidecarExtensions;
    }
}