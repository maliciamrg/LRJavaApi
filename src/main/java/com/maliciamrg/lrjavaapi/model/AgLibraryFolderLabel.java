package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryFolderLabel")
public class AgLibraryFolderLabel implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "id_global", unique = true, nullable = false)
    private Long idGlobal;
    @Column(name = "folder", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Integer folder;
    @Column(name = "label")
    private String label;
    @Column(name = "labelData")
    private String labelData;
    @Column(name = "labelGenerics")
    private String labelGenerics;
    @Column(name = "labelType", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String labelType;

    public AgLibraryFolderLabel(Long idLocal, Long idGlobal, Integer folder, String label, String labelData, String labelGenerics, String labelType) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.folder = folder;
        this.label = label;
        this.labelData = labelData;
        this.labelGenerics = labelGenerics;
        this.labelType = labelType;
    }

    public AgLibraryFolderLabel() {
    }


    @Override
    public String toString() {
        return "AgLibraryFolderLabel{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", folder=" + folder +
                ", label='" + label + '\'' +
                ", labelData='" + labelData + '\'' +
                ", labelGenerics='" + labelGenerics + '\'' +
                ", labelType='" + labelType + '\'' +
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

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelData() {
        return labelData;
    }

    public void setLabelData(String labelData) {
        this.labelData = labelData;
    }

    public String getLabelGenerics() {
        return labelGenerics;
    }

    public void setLabelGenerics(String labelGenerics) {
        this.labelGenerics = labelGenerics;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    // Add getters and setters
}
