public non-sealed class USAclock extends Clock{

    private String periodIndicator;

    public String getPeriodIndicator(){
        return this.periodIndicator;
    }

    public void setAfterMidday(){
        this.periodIndicator = "PM";
    }

    public void setBeforeMidday(){
        this.periodIndicator = "AM";
    }

    public void setHour(int hour) {
        setBeforeMidday();
        if (hour > 12 && hour <= 23){
            setAfterMidday();
            this.hour = hour - 12;
        } else if (this.hour >= 24){
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }
    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock){
            case USAclock usaClock ->{
                this.hour = usaClock.getHour();
                this.periodIndicator = usaClock.getPeriodIndicator();
            }
            case BRLclock brlClock -> this.setHour(brlClock.getHour()); //já faz a verificação se a hora for maior que 12
        }
        return this;
    }

    @Override
    public String getTime(){
        return super.getTime() + " " + this.periodIndicator;
    }

}
