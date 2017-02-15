package dev.flash.bitcoinhistory;

/**
 * Created by Flash on 15/02/2017.
 */

public class Launcher {
    public static void main(String[] args) {
        Instance instance = new Instance("Bitcoin History", 1100, 600);
        instance.start();
    }
}

