package pl.sda.Gfx;

import java.awt.EventQueue;

public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MyFrame();
            }
        });

        System.out.println("aaa");
    }
}
