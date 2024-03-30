package com.maliciamrg.lrjavaapi.dto;

public class AgLibraryKeywordDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Long idGlobal;
    private String dateCreated;
    private String genealogy;
    private Integer imageCountCache;
    private Integer includeOnExport;
    private Integer includeParents;
    private Integer includeSynonyms;
    private String keywordType;
    private String lastApplied;
    private String lcName;
    private String name;
    private Long parent;

    public AgLibraryKeywordDTO(Long idLocal, Long idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    public AgLibraryKeywordDTO(Long idLocal, Long idGlobal, String dateCreated, String genealogy, Integer imageCountCache, Integer includeOnExport, Integer includeParents, Integer includeSynonyms, String keywordType, String lastApplied, String lcName, String name, Long parent) {
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

    public AgLibraryKeywordDTO() {
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

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setGenealogy(String genealogy) {
        this.genealogy = genealogy;
    }

    public String getGenealogy() {
        return this.genealogy;
    }

    public void setImageCountCache(Integer imageCountCache) {
        this.imageCountCache = imageCountCache;
    }

    public Integer getImageCountCache() {
        return this.imageCountCache;
    }

    public void setIncludeOnExport(Integer includeOnExport) {
        this.includeOnExport = includeOnExport;
    }

    public Integer getIncludeOnExport() {
        return this.includeOnExport;
    }

    public void setIncludeParents(Integer includeParents) {
        this.includeParents = includeParents;
    }

    public Integer getIncludeParents() {
        return this.includeParents;
    }

    public void setIncludeSynonyms(Integer includeSynonyms) {
        this.includeSynonyms = includeSynonyms;
    }

    public Integer getIncludeSynonyms() {
        return this.includeSynonyms;
    }

    public void setKeywordType(String keywordType) {
        this.keywordType = keywordType;
    }

    public String getKeywordType() {
        return this.keywordType;
    }

    public void setLastApplied(String lastApplied) {
        this.lastApplied = lastApplied;
    }

    public String getLastApplied() {
        return this.lastApplied;
    }

    public void setLcName(String lcName) {
        this.lcName = lcName;
    }

    public String getLcName() {
        return this.lcName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getParent() {
        return this.parent;
    }
}