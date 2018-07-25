package org.cd.corp;

import org.cd.corp.controller.ControllerRoom;
import org.cd.corp.model.Coordinates;
import org.cd.corp.model.Order;
import org.cd.corp.model.TimeWindow;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        ControllerRoom room = null;
        do {
            Coordinates distributionCoordinates = new Coordinates(Math.random(), Math.random());
            room = new ControllerRoom(distributionCoordinates, 8, 0, 16, 0, 90);
            Random random = new Random();
            for (int i = 0; i < 50 + random.nextInt(20); i++) {
                int startH = random.nextInt(6) + 8;
                int startM = random.nextInt(60);
                int endH = startH + random.nextInt(5);
                int endM = random.nextInt(60);
                var start = LocalTime.of(startH, startM);
                var end = LocalTime.of(endH, endM);
                if (end.isBefore(start)) {
                    end = end.plusHours(1);
                }
                if (end.isAfter(room.getDistributionCenter().getTimeWindow().getEndTime())) {
                    end = room.getDistributionCenter().getTimeWindow().getEndTime();
                }
                var orderTimeWindow = new TimeWindow(start, end);
                Order order = new Order(new Coordinates(Math.random(), Math.random()), 100, orderTimeWindow, 20, 10);

                room.addOrder(order);
            }
            room.optimizeOrders();
            room.getUnreachedOrders().forEach(System.out::println);
        } while (room.getUnreachedOrders().size() == 0);
    }
}