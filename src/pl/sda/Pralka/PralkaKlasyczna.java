package pl.sda.Pralka;

public class PralkaKlasyczna implements Pralka{

    private LaundryType laundryType = LaundryType.MIXED;

    @Override
    public void start() {
        // zrób jakiś dźwięk
        // wypierz zgodnie z przpisem danej firmy
        // zrób jakiś dźwięk
    }

    @Override
    public void setLaundryType(LaundryType laundryType) {
        this.laundryType = laundryType;
    }

    @Override
    public int getMinutesTillEnd() {
        switch (laundryType) {
            case WOOL: return 200;
            case POLYESTER: return 160;
            default: return 180;
        }
    }
}
