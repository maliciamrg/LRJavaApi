package com.maliciamrg.lrjavaapi.adobeimages;

import javax.persistence.*;

@Entity
@Table(name = "Adobe_images")
@NamedQueries({
        @NamedQuery(name = "AdobeImages.countBy", query = "select count(a) from AdobeImages a")
})
public class AdobeImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Integer idLocal;

    @Column(name = "id_global")
    private String idGlobal;

    @Column(name = "aspectRatioCache")
    private Integer aspectRatioCache = -1;

    @Column(name = "bitDepth")
    private Integer bitDepth = 0;

    @Column(name = "captureTime")
    private String captureTime;

    @Column(name = "colorChannels")
    private Integer colorChannels = 0;

    @Column(name = "colorLabels")
    private String colorLabels = "";

    @Column(name = "colorMode")
    private Integer colorMode = -1;

    @Column(name = "copyCreationTime")
    private long copyCreationTime = -63113817600L;

    @Column(name = "copyName")
    private String copyName;

    @Column(name = "copyReason")
    private String copyReason;

    @Column(name = "developSettingsIDCache")
    private String developSettingsIDCache;

    @Column(name = "fileFormat")
    private String fileFormat = "unset";

    @Column(name = "fileHeight")
    private Integer fileHeight;

    @Column(name = "fileWidth")
    private Integer fileWidth;

    @Column(name = "hasMissingSidecars")
    private Integer hasMissingSidecars;

    @Column(name = "masterImage")
    private Integer masterImage;

    @Column(name = "orientation")
    private String orientation;

    @Column(name = "originalCaptureTime")
    private String originalCaptureTime;

    @Column(name = "originalRootEntity")
    private Integer originalRootEntity;

    @Column(name = "panningDistanceH")
    private Integer panningDistanceH;

    @Column(name = "panningDistanceV")
    private Integer panningDistanceV;

    @Column(name = "pick")
    private Integer pick = 0;

    @Column(name = "positionInFolder")
    private String positionInFolder = "z";

    @Column(name = "propertiesCache")
    private String propertiesCache;

    @Column(name = "pyramidIDCache")
    private String pyramidIDCache;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "rootFile")
    private Integer rootFile = 0;

    @Column(name = "sidecarStatus")
    private String sidecarStatus;

    @Column(name = "touchCount")
    private Integer touchCount = 0;

    @Column(name = "touchTime")
    private Integer touchTime = 0;


    @Override
    public String toString() {
        return "AdobeImages{" +
                "idLocal=" + idLocal +
                ", idGlobal=" + idGlobal +
                ", captureTime='" + captureTime + '\'' +
                ", colorLabels='" + colorLabels + '\'' +
                ", copyCreationTime=" + copyCreationTime +
                ", copyName='" + copyName + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", originalCaptureTime='" + originalCaptureTime + '\'' +
                ", originalRootEntity=" + originalRootEntity +
                ", pick=" + pick +
                ", positionInFolder='" + positionInFolder + '\'' +
                ", rating=" + rating +
                ", rootFile=" + rootFile +
                ", sidecarStatus='" + sidecarStatus + '\'' +
                ", touchCount=" + touchCount +
                ", touchTime=" + touchTime +
                '}';
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getIdGlobal() {
        return idGlobal;
    }

    public void setIdGlobal(String idGlobal) {
        this.idGlobal = idGlobal;
    }

    public Integer getAspectRatioCache() {
        return aspectRatioCache;
    }

    public void setAspectRatioCache(Integer aspectRatioCache) {
        this.aspectRatioCache = aspectRatioCache;
    }

    public Integer getBitDepth() {
        return bitDepth;
    }

    public void setBitDepth(Integer bitDepth) {
        this.bitDepth = bitDepth;
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }

    public Integer getColorChannels() {
        return colorChannels;
    }

    public void setColorChannels(Integer colorChannels) {
        this.colorChannels = colorChannels;
    }

    public String getColorLabels() {
        return colorLabels;
    }

    public void setColorLabels(String colorLabels) {
        this.colorLabels = colorLabels;
    }

    public Integer getColorMode() {
        return colorMode;
    }

    public void setColorMode(Integer colorMode) {
        this.colorMode = colorMode;
    }

    public long getCopyCreationTime() {
        return copyCreationTime;
    }

    public void setCopyCreationTime(long copyCreationTime) {
        this.copyCreationTime = copyCreationTime;
    }

    public String getCopyName() {
        return copyName;
    }

    public void setCopyName(String copyName) {
        this.copyName = copyName;
    }

    public String getCopyReason() {
        return copyReason;
    }

    public void setCopyReason(String copyReason) {
        this.copyReason = copyReason;
    }

    public String getDevelopSettingsIDCache() {
        return developSettingsIDCache;
    }

    public void setDevelopSettingsIDCache(String developSettingsIDCache) {
        this.developSettingsIDCache = developSettingsIDCache;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public Integer getFileHeight() {
        return fileHeight;
    }

    public void setFileHeight(Integer fileHeight) {
        this.fileHeight = fileHeight;
    }

    public Integer getFileWidth() {
        return fileWidth;
    }

    public void setFileWidth(Integer fileWidth) {
        this.fileWidth = fileWidth;
    }

    public Integer getHasMissingSidecars() {
        return hasMissingSidecars;
    }

    public void setHasMissingSidecars(Integer hasMissingSidecars) {
        this.hasMissingSidecars = hasMissingSidecars;
    }

    public Integer getMasterImage() {
        return masterImage;
    }

    public void setMasterImage(Integer masterImage) {
        this.masterImage = masterImage;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOriginalCaptureTime() {
        return originalCaptureTime;
    }

    public void setOriginalCaptureTime(String originalCaptureTime) {
        this.originalCaptureTime = originalCaptureTime;
    }

    public Integer getOriginalRootEntity() {
        return originalRootEntity;
    }

    public void setOriginalRootEntity(Integer originalRootEntity) {
        this.originalRootEntity = originalRootEntity;
    }

    public Integer getPanningDistanceH() {
        return panningDistanceH;
    }

    public void setPanningDistanceH(Integer panningDistanceH) {
        this.panningDistanceH = panningDistanceH;
    }

    public Integer getPanningDistanceV() {
        return panningDistanceV;
    }

    public void setPanningDistanceV(Integer panningDistanceV) {
        this.panningDistanceV = panningDistanceV;
    }

    public Integer getPick() {
        return pick;
    }

    public void setPick(Integer pick) {
        this.pick = pick;
    }

    public String getPositionInFolder() {
        return positionInFolder;
    }

    public void setPositionInFolder(String positionInFolder) {
        this.positionInFolder = positionInFolder;
    }

    public String getPropertiesCache() {
        return propertiesCache;
    }

    public void setPropertiesCache(String propertiesCache) {
        this.propertiesCache = propertiesCache;
    }

    public String getPyramidIDCache() {
        return pyramidIDCache;
    }

    public void setPyramidIDCache(String pyramidIDCache) {
        this.pyramidIDCache = pyramidIDCache;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRootFile() {
        return rootFile;
    }

    public void setRootFile(Integer rootFile) {
        this.rootFile = rootFile;
    }

    public String getSidecarStatus() {
        return sidecarStatus;
    }

    public void setSidecarStatus(String sidecarStatus) {
        this.sidecarStatus = sidecarStatus;
    }

    public Integer getTouchCount() {
        return touchCount;
    }

    public void setTouchCount(Integer touchCount) {
        this.touchCount = touchCount;
    }

    public Integer getTouchTime() {
        return touchTime;
    }

    public void setTouchTime(Integer touchTime) {
        this.touchTime = touchTime;
    }
}

