import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class App {
    public static void main(String[] args){
        var calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//a hora em maiúsculo é o formato do Brasil, minúsculo é o do USA
        System.out.println("\n"+calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //Inicia no 0 (janeiro é 0)
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(formatter.format(calendar.getTime())); //retorna igual a Classe Date

        var newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 1);
        System.out.println(calendar.before(newCalendar)); //true confere se calendar vem antes de newCalendar
    }
}
//Também está em desuso, a mais usada é a java.time