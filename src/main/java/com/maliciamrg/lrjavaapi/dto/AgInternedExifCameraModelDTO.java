package com.maliciamrg.lrjavaapi.dto;

public class AgInternedExifCameraModelDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Integer searchIndex;
    private String value;

    public AgInternedExifCameraModelDTO(Long idLocal, Integer searchIndex, String value) {
        this.idLocal = idLocal;
        this.searchIndex = searchIndex;
        this.value = value;
    }

    public AgInternedExifCameraModelDTO() {
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdLocal() {
        return this.idLocal;
    }

    public void setSearchIndex(Integer searchIndex) {
        this.searchIndex = searchIndex;
    }

    public Integer getSearchIndex() {
        return this.searchIndex;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}