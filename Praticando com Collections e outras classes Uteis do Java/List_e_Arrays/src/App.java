import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class App {
    public static void main(String[] args){
        int[] code = {789, 356}; //ao inicializar assim, automaticamente o tamanho é 2
        System.out.println(code.length);
        //System.out.println(code[0]);
        //System.out.println(code[1]);
        int[] numeros = new int[5]; //Outra forma de definir o tamanho do array. 5 posições

        List<Integer> codes2 = new ArrayList<>(); //*Lista dinâmica sem tamanho fixo
        codes2.add(code[0]); //encapsula o int 789 no array de objetos. é igual codes2.add(Integer.valueOf(code[0]));
        codes2.add(code[1]);
        codes2.add(000);
        codes2.forEach(System.out::println);
        
        List<Integer> code3 = new LinkedList<>(); //*Mais indicado para muita inclusão e remoção de itens da lista
        List<Integer> code4 = new Vector<>();

    }
}
