public class App {
    public static void main(String[] args){
        int i = 0; //*Tipo primitivo
        printValue(i); //chama o metodo -> resultado 0
        System.out.println(i);
   }
public static void printValue(final int i) {
    var ii = i;
    System.out.println(++ii);
}
}
