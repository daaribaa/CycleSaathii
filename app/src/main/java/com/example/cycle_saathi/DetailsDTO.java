package com.example.cycle_saathi;

public class DetailsDTO {

    String distance, time, avgSpeed, elevationGain;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(String avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(String elevationGain) {
        this.elevationGain = elevationGain;
    }

    public DetailsDTO(String distance, String time, String avgSpeed, String elevationGain) {
        this.distance = distance;
        this.time = time;
        this.avgSpeed = avgSpeed;
        this.elevationGain = elevationGain;
    }
}
