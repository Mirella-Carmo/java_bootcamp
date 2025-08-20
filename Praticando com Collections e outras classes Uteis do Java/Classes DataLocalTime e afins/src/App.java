//* utilizando LocalDate
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n"+formatter.format(localDate));

        var strDate = "02/05/2025";
        System.out.println(formatter.format(localDate.parse(strDate, formatter)));

        System.out.println("\n"+localDate.plus(6,ChronoUnit.DAYS));
        System.out.println(localDate.minusMonths(4)); //também tem com dias e anos
        System.out.println(localDate.getMonth()); //*MonthValue retorna o número (é um enum)
        
        System.out.println(localDate.equals(strDate)); //compara o objeto, se ano mes dia e TIPO (localDate) são iguais
        JapaneseDate japaneseDate = JapaneseDate.now();
        System.out.println(localDate.isEqual(japaneseDate)); //true, porem se fosse com equals retornaria false, pois os tipos são diferentes
    }
}
