package pl.sda.Wzorce;

public class AppSingletons {

    public static void main(String[] args) {

        System.out.println(SimpleEagerCounter.getInstance().getCurrentCount());

        SimpleEagerCounter simpleCounterA = SimpleEagerCounter.getInstance();
        SimpleEagerCounter simpleCounterB = SimpleEagerCounter.getInstance();
        System.out.println(simpleCounterA == simpleCounterB); // true -> obie referencje wskazują na ten SAM obiekt

        simpleCounterA.increment();
        simpleCounterB.increment();
        System.out.println(simpleCounterA.getCurrentCount()); // 2


//      A teraz przez enuma

        SimpleCounterEnum simpleCounterEA = SimpleCounterEnum.INSTANCE;
        SimpleCounterEnum simpleCounterEB = SimpleCounterEnum.INSTANCE;
        System.out.println(simpleCounterEA == simpleCounterEB); // również true

        simpleCounterEA.increment();
        simpleCounterEB.increment();
        System.out.println(simpleCounterEA.getCurrentCount()); // 2


//     Lazy bez synchronizacji

        SimpleLazyCounter simpleLazyCounterA = SimpleLazyCounter.getInstance();
        SimpleLazyCounter simpleLazyCounterB = SimpleLazyCounter.getInstance();

        System.out.println(simpleLazyCounterA==simpleLazyCounterB);

        simpleLazyCounterA.increment();
        simpleLazyCounterB.increment();

        System.out.println(simpleLazyCounterA.getCurrentCount());



    }
}

