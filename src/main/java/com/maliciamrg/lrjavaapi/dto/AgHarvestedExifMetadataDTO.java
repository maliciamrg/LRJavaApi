package com.maliciamrg.lrjavaapi.dto;

public class AgHarvestedExifMetadataDTO extends AbstractDTO<Long> {
    private Long idLocal;
    private Integer image;
    private String aperture;
    private Integer cameraModelRef;
    private Integer cameraSNRef;
    private Integer dateDay;
    private Integer dateMonth;
    private Integer dateYear;
    private Integer flashFired;
    private String focalLength;
    private Double gpsLatitude;
    private Double gpsLongitude;
    private Integer gpsSequence;
    private Integer hasGPS;
    private Integer isoSpeedRating;
    private Integer lensRef;
    private String shutterSpeed;

    public AgHarvestedExifMetadataDTO() {
    }

    public AgHarvestedExifMetadataDTO(Long idLocal, Integer image) {
        this.idLocal = idLocal;
        this.image = image;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Long getIdLocal() {
        return this.idLocal;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getImage() {
        return this.image;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public String getAperture() {
        return this.aperture;
    }

    public void setCameraModelRef(Integer cameraModelRef) {
        this.cameraModelRef = cameraModelRef;
    }

    public Integer getCameraModelRef() {
        return this.cameraModelRef;
    }

    public void setCameraSNRef(Integer cameraSNRef) {
        this.cameraSNRef = cameraSNRef;
    }

    public Integer getCameraSNRef() {
        return this.cameraSNRef;
    }

    public void setDateDay(Integer dateDay) {
        this.dateDay = dateDay;
    }

    public Integer getDateDay() {
        return this.dateDay;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Integer getDateMonth() {
        return this.dateMonth;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getDateYear() {
        return this.dateYear;
    }

    public void setFlashFired(Integer flashFired) {
        this.flashFired = flashFired;
    }

    public Integer getFlashFired() {
        return this.flashFired;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getFocalLength() {
        return this.focalLength;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLatitude() {
        return this.gpsLatitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Double getGpsLongitude() {
        return this.gpsLongitude;
    }

    public void setGpsSequence(Integer gpsSequence) {
        this.gpsSequence = gpsSequence;
    }

    public Integer getGpsSequence() {
        return this.gpsSequence;
    }

    public void setHasGPS(Integer hasGPS) {
        this.hasGPS = hasGPS;
    }

    public Integer getHasGPS() {
        return this.hasGPS;
    }

    public void setIsoSpeedRating(Integer isoSpeedRating) {
        this.isoSpeedRating = isoSpeedRating;
    }

    public Integer getIsoSpeedRating() {
        return this.isoSpeedRating;
    }

    public void setLensRef(Integer lensRef) {
        this.lensRef = lensRef;
    }

    public Integer getLensRef() {
        return this.lensRef;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getShutterSpeed() {
        return this.shutterSpeed;
    }
}