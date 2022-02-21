package DAL;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TimeHelper {
    private final LocalDateTime today = LocalDateTime.of(2022, Month.FEBRUARY, 21, 10, 20); //"i dag" En falsk dato
    private final LocalDateTime todayMorning = LocalDateTime.of(2022, Month.FEBRUARY, 21, 8, 14);

    public LocalDateTime getToday() {
        return today;
    }
    public String getTodayTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return today.format(formatter);
    }
    public LocalDateTime getTodayMorning() {
        return todayMorning;
    }
}
