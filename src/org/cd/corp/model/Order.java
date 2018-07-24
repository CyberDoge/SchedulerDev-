package org.cd.corp.model;

import java.time.LocalTime;

public class Order {
    private Coordinates coordinates;
    private int weight;
    private TimeWindow timeWindow;
    private LocalTime uploadTime;
    private LocalTime unloadTime;

    public Order(Coordinates coordinates, int weight, TimeWindow timeWindow, LocalTime uploadTime, LocalTime unloadTime) {
        this.coordinates = coordinates;
        this.weight = weight;
        this.timeWindow = timeWindow;
        this.uploadTime = uploadTime;
        this.unloadTime = unloadTime;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public int getWeight() {
        return weight;
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public LocalTime getUploadTime() {
        return uploadTime;
    }

    public LocalTime getUnloadTime() {
        return unloadTime;
    }
}
