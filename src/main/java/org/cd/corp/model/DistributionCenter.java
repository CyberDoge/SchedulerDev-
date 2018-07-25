package org.cd.corp.model;

public class DistributionCenter {
    private Coordinates coordinates;
    private TimeWindow timeWindow;
    private int fleet;

    public DistributionCenter(Coordinates coordinates, TimeWindow timeWindow, int fleet) {

        this.coordinates = coordinates;
        this.timeWindow = timeWindow;
        this.fleet = fleet;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public int getFleet() {
        return fleet;
    }

    public void takeResource() {
        fleet--;
    }

    public void freeResource() {
        fleet++;
    }

    @Override
    public String toString() {
        return "DistributionCenter{" +
                "coordinates=" + coordinates +
                ", timeWindow=" + timeWindow +
                ", fleet=" + fleet +
                '}';
    }
}
