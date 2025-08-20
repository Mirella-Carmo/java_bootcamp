//*Se precisar tem como misturar as duas formas de data. Pode ser preciso em sistemas antios
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class CalenderToDateLocal {
    public static void main(String[] args) {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        LocalDateTime localDateTimeFromCalendar = calendartoLocal(calendar);
        System.out.println("\nTransformou de Calendar para LocalDateTime: " + localDateTimeFromCalendar);
    }

    //*Transformando o valor Calendar em DataLocal
    public static LocalDateTime calendartoLocal(Calendar calendar){
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
    }
}
