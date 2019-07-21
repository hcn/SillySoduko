package com.mailtux.silly;

public class Kvadrat {
    private final Linje første;
    private final Linje andre;
    private final Linje tredje;
    private final Linje fjerde;

    public Kvadrat(Linje første, Linje andre, Linje tredje, Linje fjerde) {
        this.første=første;
        this.andre=andre;
        this.tredje=tredje;
        this.fjerde=fjerde;
    }

    public Linje getFørste() {
        return første;
    }

    public Linje getAndre() {
        return andre;
    }

    public Linje getTredje() {
        return tredje;
    }

    public Linje getFjerde() {
        return fjerde;
    }

    public String toString(){
        return første.toString()+"\n"+ andre.toString()+"\n"+tredje.toString()+"\n"+fjerde.toString();

    }

    public boolean sjekk() {
       // Linje første = kvadrat.getFørste();
     //   Linje andre = kvadrat.getAndre();
      //  Linje tredje = kvadrat.getTredje();
        //  Linje fjerde = kvadrat.getFjerde();


        int sum = første.getSum();
        if ((første.l1 + andre.l1 + tredje.l1 + fjerde.l1) != sum) {
            return false;
        }

        if ((første.l2 + andre.l2 + tredje.l2 + fjerde.l2) != sum) {
            return false;
        }

        if ((første.l3 + andre.l3 + tredje.l3 + fjerde.l3) != sum) {
            return false;
        }

        if ((første.l4 + andre.l4 + tredje.l4 + fjerde.l4) != sum) {
            return false;
        }

        if ((første.l1 + andre.l2 + tredje.l3 + fjerde.l4) != sum) {
            return false;
        }

        if ((første.l4 + andre.l3 + tredje.l2 + fjerde.l1) != sum) {
            return false;
        }

        return true;

    }
}
