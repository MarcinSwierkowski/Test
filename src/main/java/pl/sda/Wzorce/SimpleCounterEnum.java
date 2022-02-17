package pl.sda.Wzorce;

public enum SimpleCounterEnum {
    INSTANCE;

    private int currentCount = 0;

    public int getCurrentCount() {
        return currentCount;
    }

    public void increment() {
        currentCount++;
    }
}
