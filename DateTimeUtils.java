


import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;


public class DateTimeUtils {


    public static Date getUTCDate(Date dt) {

        Instant instant = Instant.ofEpochMilli(dt.getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        return java.sql.Timestamp.valueOf(ldt.toLocalDate().atTime(ldt.getHour(), ldt.getMinute(), ldt.getSecond(), ldt.getNano()));


    }

    public static Date getUTCDate(DateTime jodaDateTime) {

        Instant instant = Instant.ofEpochMilli(jodaDateTime.getMillis());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        return java.sql.Timestamp.valueOf(ldt.toLocalDate().atTime(ldt.getHour(), ldt.getMinute(), ldt.getSecond(), ldt.getNano()));


    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Date());
        System.out.println(getUTCDate(new Date()));
        System.out.println(getUTCDate(new DateTime()));
        System.out.println(TimeZone.getDefault());

    }
}


