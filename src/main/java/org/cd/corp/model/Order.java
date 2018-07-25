package org.cd.corp.model;

public class Order {
    private Coordinates coordinates;
    private int weight;
    private TimeWindow timeWindow;
    private int uploadTime;
    private int unloadTime;

    public Order(Coordinates coordinates, int weight, TimeWindow timeWindow, int uploadTime, int unloadTime) {
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

    public int getUploadTime() {
        return uploadTime;
    }

    public int getUnloadTime() {
        return unloadTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "coordinates=" + coordinates +
                ", weight=" + weight +
                ", timeWindow=" + timeWindow +
                ", uploadTime=" + uploadTime +
                ", unloadTime=" + unloadTime +
                '}';
    }
}
