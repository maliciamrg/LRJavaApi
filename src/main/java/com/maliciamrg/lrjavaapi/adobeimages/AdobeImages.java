package com.maliciamrg.lrjavaapi.adobeimages;

import javax.persistence.*;

@Entity
@Table(name = "Adobe_images")
public class AdobeImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_local")
    private Integer idLocal;

    @Column(name = "id_global")
    private Integer idGlobal;

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
                ", rootFile=" + rootFile +
                '}';
    }
}

