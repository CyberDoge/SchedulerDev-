import org.cd.corp.controller.ControllerRoom;
import org.cd.corp.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BuildDeliveringTest {
    @Test
    void foo() {
        ControllerRoom room = new ControllerRoom(new Coordinates(Math.random(), Math.random()),
                8, 0, 16, 0, 100);
        Random random = new Random();
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
        System.out.println("orderTimeWindow: " + orderTimeWindow);

        //traveling time in minutes
        var travelingTime = Coordinates.countDistance(room.getDistributionCenter().getCoordinates(), order.getCoordinates()) / Resource.getVelocityMetersPerMin();
        System.out.println("travelingTime = " + travelingTime);

        var delivering = Delivering.createDeliveringSchedule(order.getUploadTime(), order.getUnloadTime(), travelingTime, orderTimeWindow, room.getDistributionCenter().getTimeWindow());
        assertNotNull(delivering);
        System.out.println(delivering);
    }
}
