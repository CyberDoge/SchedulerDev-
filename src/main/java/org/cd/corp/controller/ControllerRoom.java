package org.cd.corp.controller;

import org.cd.corp.model.Coordinates;
import org.cd.corp.model.DistributionCenter;
import org.cd.corp.model.Order;
import org.cd.corp.model.TimeWindow;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControllerRoom {
    private DistributionCenter distributionCenter;
    private List<Order> orderListToNextDay;
    private List<Order> optimizedOrderList;

    public ControllerRoom(Coordinates distributionCenterCoordinates, int startWorkingHour, int startWorkingMin,
                          int endWorkingHour, int endWorkingMin, int fleet) {
        //start working time
        var distributionStartTime = LocalTime.of(startWorkingHour, startWorkingMin);
        //end working time
        var distributionEndTime = LocalTime.of(endWorkingHour, endWorkingMin);
        //timeWindow
        var distributionTimeWindow = new TimeWindow(distributionStartTime, distributionEndTime);

        distributionCenter = new DistributionCenter(distributionCenterCoordinates, distributionTimeWindow, fleet);

        orderListToNextDay = new ArrayList<>();
    }

    public DistributionCenter getDistributionCenter() {
        return distributionCenter;
    }

    public void optimizeOrders() {
        optimizedOrderList = new ArrayList<>();
        orderListToNextDay.sort(Comparator.comparing((order) -> order.getTimeWindow().getStartingTime()));
        var iterator = orderListToNextDay.iterator();
        iterator.next();
    }

    public void addOrder(Order order) {
        assert order != null;
        orderListToNextDay.add(order);
    }

}
