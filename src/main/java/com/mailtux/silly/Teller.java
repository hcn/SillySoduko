package com.mailtux.silly;

public class Teller {

    int ant;
    public Teller(){
        this.ant=0;
    }

    public void add(){
        this.ant++;
    }

    public int get(){
       return ant;
    }
}
