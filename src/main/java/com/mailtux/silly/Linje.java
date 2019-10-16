package com.mailtux.silly;

public class Linje {

    public int l1;
    public int l2;
    public int l3;
    public int l4;
    public int sum;
    public int l;

    public Linje(int l) {
        this.l=l;

        this.l4=l % 10;
        this.l3=l/10 % 10;
        this.l2=l/100 % 10;
        this.l1=l/1000 % 10;

        this.sum=l1+l2+l3+l4;
    }

    public String toString() {
        return sum+": "+l1+" "+l2+" "+l3+" "+l4;

    }

    public int getSum() {
        return sum;
    }

    public int getForste() {
        return l1;
    }
}
