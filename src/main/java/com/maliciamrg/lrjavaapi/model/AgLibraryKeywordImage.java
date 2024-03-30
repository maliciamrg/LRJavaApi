package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryKeywordImage")
public class AgLibraryKeywordImage implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "image", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Long image;
    @Column(name = "tag", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    private Long tag;
    public AgLibraryKeywordImage(Long idLocal, Long image, Long tag) {
        this.idLocal = idLocal;
        this.image = image;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "AgLibraryKeywordImage{" +
                "idLocal=" + idLocal +
                ", image=" + image +
                ", tag=" + tag +
                '}';
    }

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getImage() {
        return image;
    }

    public void setImage(Long image) {
        this.image = image;
    }

    public Long getTag() {
        return tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }

    // Add getters and setters
}
