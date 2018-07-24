package org.cd.corp.model;

import java.time.LocalTime;

public class Delivering {
    //начало погрузки
    private LocalTime startUpload;
    //конец погрузки/старт доставки
    private LocalTime startTravel;
    //время доставки клиенту/начало разгрузки
    private LocalTime endTravelTime;
    //конец погрузки/время отправки
    private LocalTime endUnload;
    //прибытие в центр
    private LocalTime endOrderDelivering;

    private TimeWindow centerWorkingTime;

    private boolean createDeliveringSchedule(int uploading, int unload, int travelingTimeHours, TimeWindow orderTimeWindow) {
        //если есть доступные машины
        startUpload = orderTimeWindow.getStartingTime().minusMinutes(uploading + travelingTimeHours);
        if (startUpload.isBefore(centerWorkingTime.getStartingTime())) {
            startUpload = centerWorkingTime.getStartingTime();
        }
        startTravel = startUpload.plusMinutes(uploading);
        endTravelTime = startTravel.plusHours(travelingTimeHours);
        endUnload = endTravelTime.plusMinutes(unload);
        endOrderDelivering = endUnload.plusHours(travelingTimeHours);
        return centerWorkingTime.getEndTime().isAfter(endOrderDelivering);
    }
}
