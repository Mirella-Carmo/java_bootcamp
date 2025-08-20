public non-sealed class BRLclock extends Clock{

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock){
            case USAclock usaClock -> {
                this.hour = (usaClock.getPeriodIndicator().equals("PM")) ? 
                            usaClock.getHour() + 12 : //ex: se for 1pm soma 12 que dará 13hrs
                            usaClock.getHour();
            }
            case BRLclock brlClock -> {
                this.hour = brlClock.getHour();
            }
        }
        return null;
    }
}
