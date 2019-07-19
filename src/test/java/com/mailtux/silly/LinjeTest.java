package com.mailtux.silly;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinjeTest {


    @Test
    public void opprett0() {
        Linje l=new Linje(0);

        assertEquals(0,l.getL1());
        assertEquals(0,l.getL2());
        assertEquals(0,l.getL3());
        assertEquals(0,l.getL4());



    }

    @Test
    public void opprett1() {
        Linje l=new Linje(1);

        assertEquals(0,l.getL1());
        assertEquals(0,l.getL2());
        assertEquals(0,l.getL3());
        assertEquals(1,l.getL4());



    }

    @Test
    public void opprett23() {
        Linje l=new Linje(23);

        assertEquals(0,l.getL1());
        assertEquals(0,l.getL2());
        assertEquals(2,l.getL3());
        assertEquals(3,l.getL4());



    }

    @Test
    public void opprett234() {
        Linje l=new Linje(234);

        assertEquals(0,l.getL1());
        assertEquals(2,l.getL2());
        assertEquals(3,l.getL3());
        assertEquals(4,l.getL4());



    }

    @Test
    public void opprett2345() {
        Linje l=new Linje(2345);

        assertEquals(2,l.getL1());
        assertEquals(3,l.getL2());
        assertEquals(4,l.getL3());
        assertEquals(5,l.getL4());



    }
}