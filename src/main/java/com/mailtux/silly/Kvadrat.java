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
}
