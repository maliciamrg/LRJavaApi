package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgLibraryKeyword")
public class AgLibraryKeyword implements AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "id_global", unique = true, nullable = false)
    private Long idGlobal;
    @Column(name = "dateCreated", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String dateCreated;
    @Column(name = "genealogy", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT ''")
    private String genealogy;
    @Column(name = "imageCountCache", columnDefinition = "INTEGER DEFAULT -1")
    private Integer imageCountCache;
    @Column(name = "includeOnExport", nullable = false, columnDefinition = "INTEGER DEFAULT 1")
    private Integer includeOnExport;
    @Column(name = "includeParents", nullable = false, columnDefinition = "INTEGER DEFAULT 1")
    private Integer includeParents;
    @Column(name = "includeSynonyms", nullable = false, columnDefinition = "INTEGER DEFAULT 1")
    private Integer includeSynonyms;
    @Column(name = "keywordType")
    private String keywordType;
    @Column(name = "lastApplied")
    private String lastApplied;
    @Column(name = "lc_name")
    private String lcName;
    @Column(name = "name")
    private String name;
    @Column(name = "parent")
    private Long parent;

    public AgLibraryKeyword(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    public AgLibraryKeyword(Long idLocal, Long idGlobal, String dateCreated, String genealogy, Integer imageCountCache, Integer includeOnExport, Integer includeParents, Integer includeSynonyms, String keywordType, String lastApplied, String lcName, String name, Long parent) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
        this.dateCreated = dateCreated;
        this.genealogy = genealogy;
        this.imageCountCache = imageCountCache;
        this.includeOnExport = includeOnExport;
        this.includeParents = includeParents;
        this.includeSynonyms = includeSynonyms;
        this.keywordType = keywordType;
        this.lastApplied = lastApplied;
        this.lcName = lcName;
        this.name = name;
        this.parent = parent;
    }

    public AgLibraryKeyword() {
    }

    @Override
    public String toString() {
        return "AgLibraryKeyword{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", dateCreated='" + dateCreated + '\'' +
                ", genealogy='" + genealogy + '\'' +
                ", imageCountCache=" + imageCountCache +
                ", includeOnExport=" + includeOnExport +
                ", includeParents=" + includeParents +
                ", includeSynonyms=" + includeSynonyms +
                ", keywordType='" + keywordType + '\'' +
                ", lastApplied='" + lastApplied + '\'' +
                ", lcName='" + lcName + '\'' +
                ", name='" + name + '\'' +
                ", parent=" + parent +
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

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getGenealogy() {
        return genealogy;
    }

    public void setGenealogy(String genealogy) {
        this.genealogy = genealogy;
    }

    public Integer getImageCountCache() {
        return imageCountCache;
    }

    public void setImageCountCache(Integer imageCountCache) {
        this.imageCountCache = imageCountCache;
    }

    public Integer getIncludeOnExport() {
        return includeOnExport;
    }

    public void setIncludeOnExport(Integer includeOnExport) {
        this.includeOnExport = includeOnExport;
    }

    public Integer getIncludeParents() {
        return includeParents;
    }

    public void setIncludeParents(Integer includeParents) {
        this.includeParents = includeParents;
    }

    public Integer getIncludeSynonyms() {
        return includeSynonyms;
    }

    public void setIncludeSynonyms(Integer includeSynonyms) {
        this.includeSynonyms = includeSynonyms;
    }

    public String getKeywordType() {
        return keywordType;
    }

    public void setKeywordType(String keywordType) {
        this.keywordType = keywordType;
    }

    public String getLastApplied() {
        return lastApplied;
    }

    public void setLastApplied(String lastApplied) {
        this.lastApplied = lastApplied;
    }

    public String getLcName() {
        return lcName;
    }

    public void setLcName(String lcName) {
        this.lcName = lcName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    // Add getters and setters
}
