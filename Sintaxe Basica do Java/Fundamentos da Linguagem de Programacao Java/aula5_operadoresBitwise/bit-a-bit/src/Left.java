//Left Shift Operator

public class Left {
    public static void main(String[] args) {
        var value1 = 9;
        var binary1 = Integer.toBinaryString(value1);
        System.out.printf("Primeiro número da operação %s (representação binária %s)\n", value1, binary1);

        var value2 = 2;
        System.out.printf("Segundo número da operação %s\n", value2);

        var result = value1 << value2;
        var binaryResult = Integer.toBinaryString(result);
        System.out.printf("%s << %s = %s (representação binária %s)\n", value1, value2, result, binaryResult);

    }
}
//o 2 indica a quant. de posições que vai deslocar, então se a representação binária do 9 é 1001, ele preenche mais dois espaços vazios a direita com 0. Resultado: 100100

/*
 Além disso tem o >> que desloca para direita e verifica (se for negativo completa com 1, se for positivo completa com 0)
 
 - >>> igual ao outro, porém sempre completa com 0, independente se for positivo ou negativo
 */