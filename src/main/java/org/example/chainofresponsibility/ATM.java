package org.example.chainofresponsibility;

public class ATM {
    private final Handler handler50;
    private final Handler handler20;
    private final Handler handler5;

    public ATM() {
        handler50 = new Handler50();
        handler20 = new Handler20();
        handler5 = new Handler5();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
    }

    public void process(int amount) {
        handler50.process(amount);
    }

}