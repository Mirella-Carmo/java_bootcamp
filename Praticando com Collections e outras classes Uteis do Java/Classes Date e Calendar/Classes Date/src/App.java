import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App {
    public static void main(String[] args){
        var date = new Date(); //API Depreciada
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        System.out.println("\n"+date);
        System.out.println(formatter.format(date));

        LocalDate dataAtual = LocalDate.now();
        System.out.println("\nData Atual com API Moderna: " + dataAtual);

        LocalDate dataFutura = dataAtual.plusDays(5);
        System.out.println("Data futura: " + dataFutura);

        // Exemplo com data e hora
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter brazilFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Data e hora atual: " + dataHoraAtual.format(brazilFormatter));
    }
}
//*Pouco utilizada em projetos modernos
//A contagem de meses começa em 0 (janeiro é 0), enquanto a de anos começa em 1900.
//Atualmente é mais utilizada a API de Data e Hora (java.time)