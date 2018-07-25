package org.cd.corp.model;

public class Order {
    private static int debugId = 0;
    private Coordinates coordinates;
    private int weight;
    private TimeWindow timeWindow;
    private int uploadTime;
    private int unloadTime;
    private Delivering delivering;
    private int personalId;

    public Order(Coordinates coordinates, int weight, TimeWindow timeWindow, int uploadTime, int unloadTime) {
        this.coordinates = coordinates;
        this.weight = weight;
        this.timeWindow = timeWindow;
        this.uploadTime = uploadTime;
        this.unloadTime = unloadTime;
        personalId = debugId++;
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

    public Delivering getDelivering() {
        return delivering;
    }

    public void setDelivering(Delivering delivering) {
        this.delivering = delivering;

    }

    @Override
    public String toString() {
        return personalId + "{" +
                "coordinates=" + coordinates +
                ", timeWindow=" + timeWindow +
                ", uploadTime=" + uploadTime +
                ", unloadTime=" + unloadTime +
                ",delivering=" + delivering +
                '}';
    }
}
