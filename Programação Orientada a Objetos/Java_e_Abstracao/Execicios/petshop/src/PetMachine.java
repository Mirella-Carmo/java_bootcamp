public class PetMachine {
    //O ideal seria fazer isso no construtor
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet; //não tem q passar o tipo?

    public void  takeAShower(){
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina:");
            return;
        } 
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo");

        this.water -= 10;
        this.shampoo -= 2;
    }

    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }
        water += 2; //permitir somente 2 litros por vez
    }

    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }
        shampoo += 2; //permitir somente 2 litros por vez
    }

    //* Para verificar a quantidade de água e shampoo basta dar um getter
    public int getWater(){
        return water;
    }

    public int getShampoo(){
        return shampoo;
    }

    //ver se o pet está no banho
    public boolean hasPet(){
        return pet != null; //true tem pet e false não tem
    }

    //colocar o pet na máquina
    public void setPet(Pet pet){
        if (!this.clean){ //condição: a maquina deve estar limpa
            System.out.println("A máquina está suja, para colocar o pet é necessário limpar"); 
            return;
        }
        if (hasPet()){
            System.out.println("O pet " + pet.getName() + " está na máquina nesse momento");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina");

    }

    //remover o pet (condição: se o pet estiver sujo a maquina também está)
    public void removePet(){
        if (!this.pet.isClean()) this.clean = false;
        System.out.println("O pet " + pet.getName() + " foi tirado da máquina");
        this.pet = null;
    }

    //limpar a maquina
    public void wash(){
        this.water -= 3;
        this.shampoo -= 1;
        this.clean = true;
        System.out.println("A máquina foi limpa");
    }
}


