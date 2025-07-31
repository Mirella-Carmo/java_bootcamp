public record Person(String name, int age){ //construtor canônico
    public Person(String name){ //construtor auxiliar
        this(name, 1);
    }
}
