package ar.edu.unrn.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class DateUtils {

    public static LocalDate todayLocalDate() {
        return LocalDate.now();
    }

    public static Date asDate(LocalDate localDate) {
        return (localDate != null) ?
                Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return (localDateTime != null) ?
                Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    public static LocalTime dateToLocalTime(Date date) {
        LocalTime localTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalTime();
        return localTime;
    }

    public static Integer getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
