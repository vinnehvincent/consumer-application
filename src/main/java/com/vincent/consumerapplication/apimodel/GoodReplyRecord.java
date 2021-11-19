package com.vincent.consumerapplication.apimodel;

public class GoodReplyRecord {
    private Long ucn;
    private boolean granted;

    public GoodReplyRecord() {
    }

    public Long getUcn() {
        return ucn;
    }

    public void setUcn(Long ucn) {
        this.ucn = ucn;
    }

    public boolean isGranted() {
        return granted;
    }

    public void setGranted(boolean granted) {
        this.granted = granted;
    }
}
