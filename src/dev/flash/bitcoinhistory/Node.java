package dev.flash.bitcoinhistory;

/**
 * Created by Flash on 15/02/2017.
 */

public class Node {
    private boolean buy;
    private float pounds;
    private float bits;

    public Node(boolean buy, float pounds, float bits) {
        this.buy = buy;
        this.pounds = pounds;
        this.bits = bits;
    }

    //Getters and Setters

    public boolean isBuy() {
        return buy;
    }

    public float getPounds() {
        return pounds;
    }

    public float getBits() {
        return bits;
    }
}
