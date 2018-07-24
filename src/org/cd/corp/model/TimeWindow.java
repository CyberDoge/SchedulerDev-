package org.cd.corp.model;

import java.time.LocalTime;

public class TimeWindow {
    private LocalTime startingTime;
    private LocalTime endTime;

    public TimeWindow(LocalTime startingTime, LocalTime endTime) {
        this.startingTime = startingTime;
        this.endTime = endTime;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTotalWorkingTimeInMinutes() {
        return endTime.getMinute() - startingTime.getMinute();
    }

    public int getRemainingWorkingTimeInMinutes() {
        return endTime.getMinute() - LocalTime.now().getMinute();
    }
}
