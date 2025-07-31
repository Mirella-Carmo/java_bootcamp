public class App {
    public static void main(String[] args){
        var value1 = 6;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro número da operação %s (representação binária %s)\n", value1, binary1);

        var value2 = 5;
        var binary2 = Integer.toBinaryString(value2);
        System.out.printf("Segundo número da operação %s (representação binária %s)\n", value2, binary2);

        var result = value1 | value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf("%s | %s = %s (representação binária %s)\n", value1, value2, result, binaryResult);

        //* Operador xor ^
        System.out.printf("%s ^ %s = %s (representação binária %s)\n", value1, value2, result, binaryResult);
        // se os numeros são iguais ele coloca 0, se diferentes coloca 1

        //*Operador complement ~
        var resultComplement = ~value1;
        var binaryComplement = Integer.toBinaryString(resultComplement);
        System.out.printf("~%s = %s (representação binária %s)\n", value1, resultComplement, binaryComplement);
        //o complement é igual ao NOT, então ele inverte os valores

    }
}


/* OU
 0 = false
 1 = true

 6 -> 110
 5 -> 101
 x -> 111 (o número equivalente ao resultado dessa operação binária é 7)
 */

//* É a mesma lógica para os outros operadores (AND e NOT)