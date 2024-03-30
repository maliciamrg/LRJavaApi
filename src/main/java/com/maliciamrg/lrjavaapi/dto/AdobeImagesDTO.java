package com.maliciamrg.lrjavaapi.dto;

public class AdobeImagesDTO extends AbstractDTO<Integer> {
    private Integer idLocal;
    private String idGlobal;
    private Integer aspectRatioCache;
    private Integer bitDepth;
    private String captureTime;
    private Integer colorChannels;
    private String colorLabels;
    private Integer colorMode;
    private long copyCreationTime;
    private String copyName;
    private String copyReason;
    private String developSettingsIDCache;
    private String fileFormat;
    private Integer fileHeight;
    private Integer fileWidth;
    private Integer hasMissingSidecars;
    private Integer masterImage;
    private String orientation;
    private String originalCaptureTime;
    private Integer originalRootEntity;
    private Integer panningDistanceH;
    private Integer panningDistanceV;
    private Integer pick;
    private String positionInFolder;
    private String propertiesCache;
    private String pyramidIDCache;
    private Integer rating;
    private Integer rootFile;
    private String sidecarStatus;
    private Integer touchCount;
    private Integer touchTime;

    public AdobeImagesDTO() {
    }

    public AdobeImagesDTO(Integer idLocal, String idGlobal) {
        this.idLocal = idLocal;
        this.idGlobal = idGlobal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getIdLocal() {
        return this.idLocal;
    }

    public void setIdGlobal(String idGlobal) {
        this.idGlobal = idGlobal;
    }

    public String getIdGlobal() {
        return this.idGlobal;
    }

    public void setAspectRatioCache(Integer aspectRatioCache) {
        this.aspectRatioCache = aspectRatioCache;
    }

    public Integer getAspectRatioCache() {
        return this.aspectRatioCache;
    }

    public void setBitDepth(Integer bitDepth) {
        this.bitDepth = bitDepth;
    }

    public Integer getBitDepth() {
        return this.bitDepth;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }

    public String getCaptureTime() {
        return this.captureTime;
    }

    public void setColorChannels(Integer colorChannels) {
        this.colorChannels = colorChannels;
    }

    public Integer getColorChannels() {
        return this.colorChannels;
    }

    public void setColorLabels(String colorLabels) {
        this.colorLabels = colorLabels;
    }

    public String getColorLabels() {
        return this.colorLabels;
    }

    public void setColorMode(Integer colorMode) {
        this.colorMode = colorMode;
    }

    public Integer getColorMode() {
        return this.colorMode;
    }

    public void setCopyCreationTime(long copyCreationTime) {
        this.copyCreationTime = copyCreationTime;
    }

    public long getCopyCreationTime() {
        return this.copyCreationTime;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName;
    }

    public String getCopyName() {
        return this.copyName;
    }

    public void setCopyReason(String copyReason) {
        this.copyReason = copyReason;
    }

    public String getCopyReason() {
        return this.copyReason;
    }

    public void setDevelopSettingsIDCache(String developSettingsIDCache) {
        this.developSettingsIDCache = developSettingsIDCache;
    }

    public String getDevelopSettingsIDCache() {
        return this.developSettingsIDCache;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return this.fileFormat;
    }

    public void setFileHeight(Integer fileHeight) {
        this.fileHeight = fileHeight;
    }

    public Integer getFileHeight() {
        return this.fileHeight;
    }

    public void setFileWidth(Integer fileWidth) {
        this.fileWidth = fileWidth;
    }

    public Integer getFileWidth() {
        return this.fileWidth;
    }

    public void setHasMissingSidecars(Integer hasMissingSidecars) {
        this.hasMissingSidecars = hasMissingSidecars;
    }

    public Integer getHasMissingSidecars() {
        return this.hasMissingSidecars;
    }

    public void setMasterImage(Integer masterImage) {
        this.masterImage = masterImage;
    }

    public Integer getMasterImage() {
        return this.masterImage;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOriginalCaptureTime(String originalCaptureTime) {
        this.originalCaptureTime = originalCaptureTime;
    }

    public String getOriginalCaptureTime() {
        return this.originalCaptureTime;
    }

    public void setOriginalRootEntity(Integer originalRootEntity) {
        this.originalRootEntity = originalRootEntity;
    }

    public Integer getOriginalRootEntity() {
        return this.originalRootEntity;
    }

    public void setPanningDistanceH(Integer panningDistanceH) {
        this.panningDistanceH = panningDistanceH;
    }

    public Integer getPanningDistanceH() {
        return this.panningDistanceH;
    }

    public void setPanningDistanceV(Integer panningDistanceV) {
        this.panningDistanceV = panningDistanceV;
    }

    public Integer getPanningDistanceV() {
        return this.panningDistanceV;
    }

    public void setPick(Integer pick) {
        this.pick = pick;
    }

    public Integer getPick() {
        return this.pick;
    }

    public void setPositionInFolder(String positionInFolder) {
        this.positionInFolder = positionInFolder;
    }

    public String getPositionInFolder() {
        return this.positionInFolder;
    }

    public void setPropertiesCache(String propertiesCache) {
        this.propertiesCache = propertiesCache;
    }

    public String getPropertiesCache() {
        return this.propertiesCache;
    }

    public void setPyramidIDCache(String pyramidIDCache) {
        this.pyramidIDCache = pyramidIDCache;
    }

    public String getPyramidIDCache() {
        return this.pyramidIDCache;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRating() {
        return this.rating;
    }

    public void setRootFile(Integer rootFile) {
        this.rootFile = rootFile;
    }

    public Integer getRootFile() {
        return this.rootFile;
    }

    public void setSidecarStatus(String sidecarStatus) {
        this.sidecarStatus = sidecarStatus;
    }

    public String getSidecarStatus() {
        return this.sidecarStatus;
    }

    public void setTouchCount(Integer touchCount) {
        this.touchCount = touchCount;
    }

    public Integer getTouchCount() {
        return this.touchCount;
    }

    public void setTouchTime(Integer touchTime) {
        this.touchTime = touchTime;
    }

    public Integer getTouchTime() {
        return this.touchTime;
    }
}