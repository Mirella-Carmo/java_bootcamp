public class Main {
    public static void main(String[] args){
        Clock brlClock = new BRLclock();
        brlClock.setSecond(0);
        brlClock.setMinute(15);
        brlClock.setHour(19);

        System.out.println("\n"+brlClock.getTime());
        System.out.println(new USAclock().convert(brlClock).getTime());
    }
}
