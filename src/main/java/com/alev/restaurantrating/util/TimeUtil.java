package com.alev.restaurantrating.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUtil {
    /**
     * If it is before 11:00 we assume that he changed his mind.
     * If it is after 11:00 then it is too late, vote can't be changed
     */

    public static boolean voteIsAfter(LocalDateTime lt) {
        return isBetween(lt.toLocalTime(), LocalTime.of(11, 0), LocalTime.MAX);
    }

    public static boolean voteIsBefore(LocalDateTime lt) {
        return isBetween(lt.toLocalTime(), LocalTime.MIN, LocalTime.of(11, 0));
    }

    private static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}
