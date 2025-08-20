//*Trabalhando com LocalTime e LocalDateTime
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("\n"+formatter.format(localTime));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ISO_DATE_TIME; //formatação padronizada ISO 8601
        System.out.println(formatter.format(localDateTime));
        //System.out.println(localDateTime); sem formatar fica assim

        Date date = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3))); //-3 é horário de brasília (sem horário de verão)
        System.out.println(date);

        OffsetDateTime offsetDateTime = OffsetDateTime.now(); //tem zona
        System.out.println(offsetDateTime);

        //UTC é a referência do relógio do mundo (zona)
        OffsetDateTime utcTime = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println("OffsetDateTime (UTC +00:00): " + utcTime);

        System.out.println("Diferença de horas UTC -> Brasília: " + 
            (offsetDateTime.getHour() - utcTime.getHour()) + " horas");
    }

}

//*offset -> é uma diferença fixa entre o horário local e o UTC
