package com.mailtux.silly;

public class Teller {

    long ant;
    public Teller(){
        this.ant=0;
    }

    public void add(){
        this.ant++;
    }

    public long get(){
       return ant;
    }
}
