package pl.sda.Pralka;

public class PralkaSmart implements Pralka{

    private LaundryType laundryType = LaundryType.MIXED;

    @Override
    public void start() {
        // zrób jakiś dźwięk
        // wyślij na serwer informację o rozpoczętym praniu, tak żeby ktoś mógł to zobaczyć na smartfonie
        // wypierz zgodnie z przpisem danej firmy
        // zrób jakiś dźwięk
        // wyślij na serwer informację o zakończonym praniu, tak żeby ktoś mógł to zobaczyć na smartfonie
    }

    @Override
    public void setLaundryType(LaundryType laundryType) {
        this.laundryType = laundryType;
    }

    @Override
    public int getMinutesTillEnd() {
        switch (laundryType) {
            case WOOL: return 180;
            case POLYESTER: return 120;
            default: return 160;
        }
    }
}
