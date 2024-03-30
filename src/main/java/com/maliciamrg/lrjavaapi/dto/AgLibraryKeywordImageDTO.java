package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryKeywordImageDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long image;
    private Long tag;

    public AgLibraryKeywordImageDTO() {
    }

    public AgLibraryKeywordImageDTO(Long idLocal, Long image, Long tag) {
        this.idLocal = idLocal;
        this.image = image;
        this.tag = tag;
    }

    public Long getIdLocal() {
        return this.idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getImage() {
        return this.image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getTag() {
        return this.tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }
}