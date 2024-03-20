package com.herbert.wanderbyway.entryPoint.rest.health;

public class VersionInfo {
    private String version;
    private String buildTime;

    public VersionInfo(String version, String buildTime) {
        this.version = version;
        this.buildTime = buildTime;
    }

    public String getVersion() {
        return version;
    }

    public String getBuildTime() {
        return buildTime;
    }
}
