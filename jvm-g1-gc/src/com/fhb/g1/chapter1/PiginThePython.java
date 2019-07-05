package com.fhb.g1.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA 2016.3.3.
 * User: fhb
 * Email: fhb7218@gmail.com
 * Date: 2019/7/4
 * Time: 15:12
 *
 * @author hbfang
 */

public class PiginThePython {
    static volatile List pigs = new ArrayList();
    static volatile int pigsEaten = 0;
    static final int ENOUGH_PIGS = 5000;

    public static void main(String[] args) throws InterruptedException {
        new PigEater().start();
        new PigDigester().start();
    }

    static class PigEater extends Thread {
        @Override
        public void run() {
            while (true) {
                //32MB per pig
                pigs.add(new byte[32 * 1024 * 1024]);
                if (pigsEaten > ENOUGH_PIGS) {
                    return;
                }
                takeANap(100);
            }
        }
    }

    static class PigDigester extends Thread {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true) {
                takeANap(2000);
                pigsEaten += pigs.size();
                pigs = new ArrayList();
                if (pigsEaten > ENOUGH_PIGS) {
                    System.out.format("Digested %d pigs in %d ms . %n", pigsEaten, System.currentTimeMillis() - start);
                    return;
                }
            }
        }
    }


    private static void takeANap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}