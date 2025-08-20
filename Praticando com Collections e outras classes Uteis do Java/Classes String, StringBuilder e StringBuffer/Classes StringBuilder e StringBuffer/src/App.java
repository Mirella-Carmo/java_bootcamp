public class App {
    public static void main(String[] args){
        //forma demorada de concatenação e que consome muita memória (em loops, por exemplo)
        String stringConcat = "value";
        stringConcat+="2";
        System.out.println(stringConcat);

        //* Formas mais eficazes: StringBuilder e StringBuffer
        //StringBuilder -> trabalha com uma thread
        var builder = new StringBuilder("123456789");
        System.out.println(builder.delete(1, 3)); //deleta do índice 1 ao 3
        System.out.println(builder.append(5));
        System.out.println(builder.deleteCharAt(0));
        System.out.println(builder.indexOf("7")); //retorna o índice
        System.out.println(builder.insert(5, "a")); //insere "a" no ínidce 5
    }
}

//usar reverse e subtring
//*pode usar o toString para converter o stringBuilder para string