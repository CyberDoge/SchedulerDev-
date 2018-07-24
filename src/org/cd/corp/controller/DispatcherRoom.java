package org.cd.corp.controller;

import org.cd.corp.model.Coordinates;
import org.cd.corp.model.DistributionCenter;
import org.cd.corp.model.Order;
import org.cd.corp.model.TimeWindow;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DispatcherRoom {
    private DistributionCenter distributionCenter;
    private List<Order> orderListToNextDay;
    private List<Order> optimizedOrderList;

    public DispatcherRoom(double dispatcherLatitude, double dispatcherLongitude, int startMin, int startHour,
                          int endMin, int endHour, int fleet) {
        //coordinates
        var distributionCenterCoordinates = new Coordinates(dispatcherLatitude, dispatcherLongitude);
        //startTime
        var distributionStartTime = LocalTime.of(startHour, startMin);
        //endTime
        var distributionEndTime = LocalTime.of(endHour, endMin);
        //timeWindow
        var distributionTimeWindow = new TimeWindow(distributionStartTime, distributionEndTime);

        distributionCenter = new DistributionCenter(distributionCenterCoordinates, distributionTimeWindow, fleet);
        orderListToNextDay = new ArrayList<>();
    }

    public void optimizeOrders() {
        var sorted = orderListToNextDay.stream().sorted(Comparator.comparing((order) ->
                order.getTimeWindow().getStartingTime())).collect(Collectors.toList());
        optimizedOrderList = new ArrayList<>();
        distributionCenter.freeResource();

    }

    public void addOrder(Order order) {
        assert order != null;
        orderListToNextDay.add(order);
    }

}
