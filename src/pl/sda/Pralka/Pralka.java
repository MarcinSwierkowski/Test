package pl.sda.Pralka;

public interface Pralka {

    void start();
    void setLaundryType(LaundryType laundryType);
    int getMinutesTillEnd();
}

enum LaundryType{
    WOOL, POLYESTER, MIXED
}
