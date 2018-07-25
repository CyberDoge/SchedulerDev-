package org.cd.corp.model;

public class Coordinates {
    private static final double MEAN_EARTH_RADIUS_KM = 6_371.0088;
    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static int countDistance(Coordinates from, Coordinates to) {
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(to.latitude - from.latitude);
        double lonDistance = Math.toRadians(to.longitude - from.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(from.latitude)) * Math.cos(Math.toRadians(to.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (R * c * 1000);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
