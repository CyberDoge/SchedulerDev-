package org.cd.corp.model;

import java.time.LocalTime;

public class Order {
    private Coordinates coordinates;
    private int weight;
    private TimeWindow timeWindow;
    private LocalTime uploadTime;
    private LocalTime unloadTime;
}
