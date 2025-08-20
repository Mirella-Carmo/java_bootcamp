//*BigDecimal serve para trabalhar com mais precisão do que o double e float

import java.math.BigDecimal;
import java.math.RoundingMode;

public class App {
    public static void main(String[] args){
        var value1 = new BigDecimal("0.3");
        var value2 = new BigDecimal("2.5");
        System.out.println(value1.add(value2));
        System.out.println(new BigDecimal("7").subtract(new BigDecimal("3")));
        System.out.println(value1.multiply(value2));
        System.out.println(value2.divide(value1, 2, RoundingMode.HALF_UP)); //esse modo arredonda pra cima se dps da vírgula for maior que zero. SEM ELE DA ERRO

        System.out.println(value1.negate()); //deixa negativo
        System.out.println(value1.pow(3));
    }
}

//O RoundingMode tem diversos tipos de arredondamento além de pra baixo e pra cima
//se não passar o bigDecimal com string ele traz um número gigante