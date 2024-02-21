package com.herbert.wanderbyway.dataprovider.trainRoute.entity.trip;

public class TrainRouteRemark {
    private String text;
    private String type;
    private String code;
    private String summary;

    public TrainRouteRemark() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
