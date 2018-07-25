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

    public static Delivering createDeliveringSchedule(int uploading, int unload, int travelingTime, TimeWindow orderTimeWindow, TimeWindow centerWorkingTime) {
        //если есть доступные машины
        Delivering delivering = new Delivering();
        delivering.centerWorkingTime = centerWorkingTime;
        delivering.startUpload = orderTimeWindow.getStartingTime().minusMinutes(uploading + travelingTime);
        if (delivering.startUpload.isBefore(delivering.centerWorkingTime.getStartingTime())) {
            delivering.startUpload = delivering.centerWorkingTime.getStartingTime();
        }
        delivering.startTravel = delivering.startUpload.plusMinutes(uploading);
        delivering.endTravelTime = delivering.startTravel.plusMinutes(travelingTime);
        delivering.endUnload = delivering.endTravelTime.plusMinutes(unload);
        delivering.endOrderDelivering = delivering.endUnload.plusMinutes(travelingTime);
        return delivering.centerWorkingTime.getEndTime().isAfter(delivering.endOrderDelivering) ? delivering : null;
    }

    public LocalTime getStartUpload() {
        return startUpload;
    }

    public LocalTime getStartTravel() {
        return startTravel;
    }

    public LocalTime getEndTravelTime() {
        return endTravelTime;
    }

    public LocalTime getEndUnload() {
        return endUnload;
    }

    public LocalTime getEndOrderDelivering() {
        return endOrderDelivering;
    }

    public TimeWindow getCenterWorkingTime() {
        return centerWorkingTime;
    }
    @Override
    public String toString() {
        return "Delivering{" +
                "startUpload=" + startUpload +
                ", startTravel=" + startTravel +
                ", endTravelTime=" + endTravelTime +
                ", endUnload=" + endUnload +
                ", endOrderDelivering=" + endOrderDelivering +
                ", centerWorkingTime=" + centerWorkingTime +
                '}';
    }
}
