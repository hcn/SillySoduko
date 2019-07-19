package com.mailtux.silly;

public class Linje {

    private int l1;
    private int l2;
    private int l3;
    private int l4;
    private int sum;
    private int l;

    public Linje(int l) {
        this.l=l;

        this.l4=l % 10;
        this.l3=l/10 % 10;
        this.l2=l/100 % 10;
        this.l1=l/1000 % 10;

        this.sum=l1+l2+l3+l4;
    }

    public String toString() {
        return sum+": "+l4+" "+l3+" "+l2+" "+l1;

    }

    public int getL1() {
        return l1;
    }

    public int getL2() {
        return l2;
    }

    public int getL3() {
        return l3;
    }

    public int getL4() {
        return l4;
    }

    public int getSum() {
        return sum;
    }

    public int getL() {
        return l;
    }



}
