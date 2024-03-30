package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryFolderLabelDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long idGlobal;
    private Integer folder;
    private String label;
    private String labelData;
    private String labelGenerics;
    private String labelType;

    public AgLibraryFolderLabelDTO() {
    }

    public AgLibraryFolderLabelDTO(Long idLocal, Long idGlobal, Integer folder, String label, String labelData, String labelGenerics, String labelType) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.folder = folder;
        this.label = label;
        this.labelData = labelData;
        this.labelGenerics = labelGenerics;
        this.labelType = labelType;
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

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public Integer getFolder() {
        return this.folder;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabelData(String labelData) {
        this.labelData = labelData;
    }

    public String getLabelData() {
        return this.labelData;
    }

    public void setLabelGenerics(String labelGenerics) {
        this.labelGenerics = labelGenerics;
    }

    public String getLabelGenerics() {
        return this.labelGenerics;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public String getLabelType() {
        return this.labelType;
    }
}