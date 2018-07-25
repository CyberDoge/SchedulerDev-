package org.cd.corp.controller;

import org.cd.corp.model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ControllerRoom {
    private DistributionCenter distributionCenter;
    private List<Order> orderListToNextDay;
    private List<Order> unreachedOrders;

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
        unreachedOrders = new ArrayList<>();
    }

    public DistributionCenter getDistributionCenter() {
        return distributionCenter;
    }

    public void optimizeOrders() {
        orderListToNextDay.sort(Comparator.comparing((order) -> order.getTimeWindow().getStartingTime()));
        Iterator<Order> iterator = orderListToNextDay.iterator();
        while (iterator.hasNext()) {
            var order = iterator.next();
            var delivering = Delivering.createDeliveringSchedule(order.getUploadTime(), order.getUnloadTime(),
                    Coordinates.countDistance(distributionCenter.getCoordinates(), order.getCoordinates()), Resource.getVelocityMetersPerMin(),
                    order.getTimeWindow(), getDistributionCenter().getTimeWindow());
            if(delivering==null) {
                unreachedOrders.add(order);
                iterator.remove();
            } else order.setDelivering(delivering);
        }
    }

    public List<Order> getOrderListToNextDay() {
        return orderListToNextDay;
    }

    public List<Order> getUnreachedOrders() {
        return unreachedOrders;
    }

    public void addOrder(Order order) {
        assert order != null;

        orderListToNextDay.add(order);
    }

}
