package com.agen.util.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {


    /**
     * 获取明天
     * @param date
     * @return
     */
    public static Date getTomorrow(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);

        localDateTime = localDateTime.plusDays(1);
        instant = localDateTime.atZone(zone).toInstant();
        Date tomorrow = Date.from(instant);
        return tomorrow;
    }
}
