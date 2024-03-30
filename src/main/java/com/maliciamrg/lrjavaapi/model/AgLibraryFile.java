package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryFile")
public class AgLibraryFile implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "id_global", unique = true, nullable = false)
    private Long idGlobal;
    @Column(name = "baseName", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String baseName;
    @Column(name = "errorMessage")
    private String errorMessage;
    @Column(name = "errorTime")
    private Long errorTime;
    @Column(name = "extension", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String extension;
    @Column(name = "externalModTime")
    private Long externalModTime;
    @Column(name = "folder", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer folder;
    @Column(name = "idx_filename", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String idxFilename;
    @Column(name = "importHash")
    private String importHash;
    @Column(name = "lc_idx_filename", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lcIdxFilename;
    @Column(name = "lc_idx_filenameExtension", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String lcIdxFilenameExtension;
    @Column(name = "md5")
    private String md5;
    @Column(name = "modTime")
    private Long modTime;
    @Column(name = "originalFilename", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String originalFilename;
    @Column(name = "sidecarExtensions")
    private String sidecarExtensions;

    public AgLibraryFile(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    public AgLibraryFile() {
    }

    @Override
    public String toString() {
        return "AgLibraryFile{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", baseName='" + baseName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorTime=" + errorTime +
                ", extension='" + extension + '\'' +
                ", externalModTime=" + externalModTime +
                ", folder=" + folder +
                ", idxFilename='" + idxFilename + '\'' +
                ", importHash='" + importHash + '\'' +
                ", lcIdxFilename='" + lcIdxFilename + '\'' +
                ", lcIdxFilenameExtension='" + lcIdxFilenameExtension + '\'' +
                ", md5='" + md5 + '\'' +
                ", modTime=" + modTime +
                ", originalFilename='" + originalFilename + '\'' +
                ", sidecarExtensions='" + sidecarExtensions + '\'' +
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

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Long errorTime) {
        this.errorTime = errorTime;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getExternalModTime() {
        return externalModTime;
    }

    public void setExternalModTime(Long externalModTime) {
        this.externalModTime = externalModTime;
    }

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public String getIdxFilename() {
        return idxFilename;
    }

    public void setIdxFilename(String idxFilename) {
        this.idxFilename = idxFilename;
    }

    public String getImportHash() {
        return importHash;
    }

    public void setImportHash(String importHash) {
        this.importHash = importHash;
    }

    public String getLcIdxFilename() {
        return lcIdxFilename;
    }

    public void setLcIdxFilename(String lcIdxFilename) {
        this.lcIdxFilename = lcIdxFilename;
    }

    public String getLcIdxFilenameExtension() {
        return lcIdxFilenameExtension;
    }

    public void setLcIdxFilenameExtension(String lcIdxFilenameExtension) {
        this.lcIdxFilenameExtension = lcIdxFilenameExtension;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getModTime() {
        return modTime;
    }

    public void setModTime(Long modTime) {
        this.modTime = modTime;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getSidecarExtensions() {
        return sidecarExtensions;
    }

    public void setSidecarExtensions(String sidecarExtensions) {
        this.sidecarExtensions = sidecarExtensions;
    }

    // Add getters and setters
}
