package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgInternedExifCameraModel")
public class AgInternedExifCameraModel implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;

    public AgInternedExifCameraModel(Long idLocal, Integer searchIndex, String value) {
        this.idLocal = idLocal;
        this.searchIndex = searchIndex;
        this.value = value;
    }

    @Column(name = "searchIndex")
    private Integer searchIndex;

    @Column(name = "value")
    private String value;

    public AgInternedExifCameraModel() {
    }

    @Override
    public String toString() {
        return "AgInternedExifCameraModel{" +
                "idLocal=" + idLocal +
                ", searchIndex=" + searchIndex +
                ", value='" + value + '\'' +
                '}';
    }

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getSearchIndex() {
        return searchIndex;
    }

    public void setSearchIndex(Integer searchIndex) {
        this.searchIndex = searchIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    // Add getters and setters
}
