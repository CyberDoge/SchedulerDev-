package org.cd.corp.model;

public class Resource {
    public static final int VELOCITY = 50;
    public static final int CAPACITY = 360;

    public static int getVelocityMetersPerMin() {
        return VELOCITY * 100 / 6;
    }
}
