package com.maliciamrg.photohelp.fileelement;

public class FileElement implements Comparable<FileElement>{
    private String filePath;
    private String fileName;
    private long captureTime;

    public FileElement(String filePath, String fileName, long captureTime) {
        this.filePath = filePath;
        this.fileName = fileName;
        this.captureTime = captureTime;
    }

    public long getCaptureTime() {
        return captureTime;
    }

    @Override
    public int compareTo(FileElement o) {
        return (int) (this.captureTime - o.getCaptureTime());
    }

    @Override
    public String toString() {
        return "FileElement{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", captureTime=" + captureTime +
                '}';
    }
}
