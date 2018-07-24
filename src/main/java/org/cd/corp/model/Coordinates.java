package org.cd.corp.model;

public class Coordinates {
    private static final double MEAN_EARTH_RADIUS_KM = 6_371.0088;
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static double countDistance(Coordinates from, Coordinates to) {
        double sigma = Math.acos(Math.sin(from.latitude) * Math.sin(to.latitude)
                + Math.cos(from.latitude) * Math.cos(to.latitude)
                * Math.cos(to.longitude - from.longitude));
        return MEAN_EARTH_RADIUS_KM * sigma;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
