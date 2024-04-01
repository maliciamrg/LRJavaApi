package com.maliciamrg.photohelp.fileelement;

import java.util.ArrayList;

class GroupOfFileElements extends ArrayList<FileElement> {
    private long captureTime;

    void setFirstDate(long captureTime) {
        this.captureTime = captureTime;
    }

    @Override
    public String toString() {
        return "GroupOfFileElements{" +
                "captureTime=" + captureTime +
                ", size=" + size() +
                '}';
    }
}
