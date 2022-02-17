package pl.sda.Wątki;

public class SynchronizacjaExample {

    public static void main(String[] args) {
        final Pair pair = new Pair(0, 0);
        new Thread(new DummyPairIncrementer(pair)).start();
        new Thread(new DummyPairIncrementer(pair)).start();
    }
}

class Pair {
    private Integer left;
    private Integer right;

    public Pair(final Integer left, final Integer right) {
        this.left = left;
        this.right = right;
    }

    public synchronized void incrementLeft() {
        left++;
    }

    public synchronized void incrementRight() {
        right++;
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }
}

class DummyPairIncrementer implements Runnable {
    private final Pair pair;

    public DummyPairIncrementer(final Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int idx = 0; idx < 100; idx++) {
            pair.incrementLeft();
            pair.incrementRight();
        }
        System.out.println(pair.getLeft() + " " + pair.getRight());
    }
}

