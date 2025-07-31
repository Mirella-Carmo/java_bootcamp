public class Car {
    private boolean isOn = false;
    private int gear = 0;
    private int speed = 0;

    public void turnOn(){ //verificação do carro em ponto morto
        if (!isOn){
            if (this.gear == 0){
            this.isOn = true;
            System.out.println("O carro foi ligado");
            } else System.out.println("Coloque o carro em ponto morto para ligar");

        } else System.out.println("O carro já está ligado");
        
    }

    public void turnOff(){
        if (!isOn) {
            System.out.println("O carro já está desligado.");
            return;

        } if (gear == 0 && speed == 0) {
            isOn = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar o carro em movimento ou com marcha engatada.");
        }
    }

    public void speedUp(){
        if (!isOn){
            System.out.println("O carro está desligado, ligue primeiro");
            return;
        }

        if (gear == 0) {
            System.out.println("Não é possível acelerar com o carro em ponto morto");
            return;
        }

        if (speed == 120) {
            System.out.println("O carro já está na velocidade máxima de 120 km/h");
            return;
        }

        if (isSpeedCompatibleWithGear(speed)){
            this.speed += 1;
            System.out.println("Acelerando");
        } else System.out.println("A marcha não é compatível com a velocidade atual");
    }

    public void brake(){
        if (!isOn){
            System.out.println("O carro está desligado");
            return;
        }

        if (this.speed >= 1){
            this.speed -= 1;
            System.out.println("Freiando");
        }
        if (this.speed == 0){
            System.out.println("Velocidade chegou a 0. O carro parou");
            return;
        }
    }

    public void turnLeftAndRight(String direction){
        if (!isOn){
            System.out.println("O carro está desligado");
            return;
        }

        if (this.speed >= 1 && this.speed <= 40){
            if (direction.equalsIgnoreCase("direita") || direction.equalsIgnoreCase("esquerda")){
                System.out.println("Virando o carro para " + direction);
            } else System.out.println("Direção inválida. Tende direita ou esquerda");
            
        } else System.out.println("Não foi possível. A velocidade deve ser no mínimo 1 e no máximo 40");
    }

    public void checkSpeed(){
        System.out.println("Velocidade atual: " + this.speed + " Km/h");
    }

    public void shiftGear(int newGear){
        if (!isOn){
            System.out.println("O carro está desligado");
            return;
        }

        if (newGear <1 || newGear >6){
            System.out.print("Marcha inválida. O carro possui marchar de 1 a 6");
            return;
        }

        if (Math.abs(newGear - gear) != 1){
            System.out.println("Não pode pular marchas");
            return;
        }

        if (!isSpeedCompatibleWithGear(speed, newGear)){
            System.out.println("A velocidade não é compatível com essa marcha");
            return;
        }
        this.gear = newGear;
        System.out.println("Marcha alterada para: " + gear);
    }

    private boolean isSpeedCompatibleWithGear(int speed){ //é só para simplificar a chamada do método, sem precisar ficar passando a velocidade e marcha a todo momento, passa somente a velocidade
        return isSpeedCompatibleWithGear(speed, gear);
    }

    private boolean isSpeedCompatibleWithGear(int speed, int gear){
        return switch(gear){
            case 0 -> speed == 0;
            case 1 -> speed >= 0 && speed <= 20;
            case 2 -> speed >= 21 && speed <= 40;
            case 3 -> speed >= 41 && speed <= 60;
            case 4 -> speed >= 61 && speed <= 80;
            case 5 -> speed >= 81 && speed <= 100;
            case 6 -> speed >= 101 && speed <= 120;
            default -> false;
        };
    }
    
}