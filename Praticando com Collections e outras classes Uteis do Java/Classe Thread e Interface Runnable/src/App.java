import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    
    private final static List<Integer> numbers = new ArrayList<>();
    
    private synchronized static void inc(int number){ //para as threads funcionarem
        numbers.add(number);
    }

    private synchronized static void show(){
        System.out.println(numbers);
    }

    //* Outra forma sem precisar dos métodos com synchronized
    private final static Queue<Integer> numbers1 = new LinkedBlockingQueue<>(250_000); //250_000 é a capacidade

    //* Outra forma que garante segurança no erro de concorrência
    private static AtomicInteger number3 = new AtomicInteger(0);

    public static void main(String[] args){
        //escrevendo varias threads que podem executar ao mesmo tempo
        Runnable inc = () ->{
            for(int i = 0; i < 100; i++){
                inc(i); //com metodo synchronized
                numbers1.add(i); //com LinkedBlockQueue
                number3.incrementAndGet(); //com AtomicInteger
            }
        };

        Runnable dec = () ->{
            for(int i = 100; i > 0; i--){
                inc(i);
                numbers1.add(i);
                number3.decrementAndGet();
            }
        };

        Runnable show = () -> {
            for(int i = 0; i < 250; i++){
                show();
                System.out.println(numbers1);
                System.out.println(number3);
            }
        };

        /*new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();*/

        var execInc = new Thread(inc);
        execInc.start();
        execInc.setName("Thread executar"); //também é possível alterar o nome padrão "Thread - 0"
        var execDec = new Thread(dec);
        execDec.start();
        var execShow = new Thread(show);
        execShow.start();

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
    }
}
//*No terminal o valor está separado por listas, porque foram dados 3 exemplos diferentes de se trbalhar
//String Buffer funciona bem para trabalhar com multi-thread