package com.maliciamrg.lrjavaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "AgHarvestedExifMetadata")
public class AgHarvestedExifMetadata implements AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Long idLocal;
    @Column(name = "image")
    private Integer image;
    @Column(name = "aperture")
    private String aperture;
    @Column(name = "cameraModelRef")
    private Integer cameraModelRef;
    @Column(name = "cameraSNRef")
    private Integer cameraSNRef;
    @Column(name = "dateDay")
    private Integer dateDay;
    @Column(name = "dateMonth")
    private Integer dateMonth;
    @Column(name = "dateYear")
    private Integer dateYear;
    @Column(name = "flashFired")
    private Integer flashFired;
    @Column(name = "focalLength")
    private String focalLength;
    @Column(name = "gpsLatitude")
    private Double gpsLatitude;
    @Column(name = "gpsLongitude")
    private Double gpsLongitude;
    @Column(name = "gpsSequence", nullable = false)
    private Integer gpsSequence = 0;
    @Column(name = "hasGPS")
    private Integer hasGPS;
    @Column(name = "isoSpeedRating")
    private Integer isoSpeedRating;
    @Column(name = "lensRef")
    private Integer lensRef;
    @Column(name = "shutterSpeed")
    private String shutterSpeed;

    public AgHarvestedExifMetadata(Long idLocal, Integer image) {
        this.idLocal = idLocal;
        this.image = image;
    }

    public AgHarvestedExifMetadata() {
    }

    public String toString() {
        return "AgHarvestedExifMetadata{" + "idLocal=" + idLocal + ", image=" + image + ", aperture='" + aperture + '\'' + ", cameraModelRef=" + cameraModelRef + ", cameraSNRef=" + cameraSNRef + ", dateDay=" + dateDay + ", dateMonth=" + dateMonth + ", dateYear=" + dateYear + ", flashFired=" + flashFired + ", focalLength='" + focalLength + '\'' + ", gpsLatitude=" + gpsLatitude + ", gpsLongitude=" + gpsLongitude + ", gpsSequence=" + gpsSequence + ", hasGPS=" + hasGPS + ", isoSpeedRating=" + isoSpeedRating + ", lensRef=" + lensRef + ", shutterSpeed='" + shutterSpeed + '\'' + '}';
    }

    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public Integer getCameraModelRef() {
        return cameraModelRef;
    }

    public void setCameraModelRef(Integer cameraModelRef) {
        this.cameraModelRef = cameraModelRef;
    }

    public Integer getCameraSNRef() {
        return cameraSNRef;
    }

    public void setCameraSNRef(Integer cameraSNRef) {
        this.cameraSNRef = cameraSNRef;
    }

    public Integer getDateDay() {
        return dateDay;
    }

    public void setDateDay(Integer dateDay) {
        this.dateDay = dateDay;
    }

    public Integer getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Integer dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Integer getDateYear() {
        return dateYear;
    }

    public void setDateYear(Integer dateYear) {
        this.dateYear = dateYear;
    }

    public Integer getFlashFired() {
        return flashFired;
    }

    public void setFlashFired(Integer flashFired) {
        this.flashFired = flashFired;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Integer getGpsSequence() {
        return gpsSequence;
    }

    public void setGpsSequence(Integer gpsSequence) {
        this.gpsSequence = gpsSequence;
    }

    public Integer getHasGPS() {
        return hasGPS;
    }

    public void setHasGPS(Integer hasGPS) {
        this.hasGPS = hasGPS;
    }

    public Integer getIsoSpeedRating() {
        return isoSpeedRating;
    }

    public void setIsoSpeedRating(Integer isoSpeedRating) {
        this.isoSpeedRating = isoSpeedRating;
    }

    public Integer getLensRef() {
        return lensRef;
    }

    public void setLensRef(Integer lensRef) {
        this.lensRef = lensRef;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    // Add getters and setters

}
