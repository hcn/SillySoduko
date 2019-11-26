package com.mailtux.silly;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SillyTest {

    private static Map<Integer, List<Linje>> map;

    @BeforeClass
    public static void before(){
        Map<Integer, List<Linje>> map = new LagLister().lagLister();
        SillyTest.map=map;
    }

    @Test
    public void test0(){
        List<Linje> linjer = map.get(0);

        long l = new Silly().lagKvadrater(0, linjer);
        assertEquals(1,l);
    }

    @Test
    public void test1(){
        List<Linje> linjer = map.get(1);

        long l = new Silly().lagKvadrater(1, linjer);
        assertEquals(4,l);
    }

    @Test
    public void test2(){
        List<Linje> linjer = map.get(2);

        long l = new Silly().lagKvadrater(2, linjer);
        assertEquals(48,l);
    }

    @Test
    public void test3(){
        List<Linje> linjer = map.get(3);

        long l = new Silly().lagKvadrater(3, linjer);
        assertEquals(200,l);
    }

    @Test
    public void test4(){
        List<Linje> linjer = map.get(4);

        long l = new Silly().lagKvadrater(4, linjer);
        assertEquals(675,l);
    }

    @Test
    public void test5(){
        List<Linje> linjer = map.get(5);

        long l = new Silly().lagKvadrater(5, linjer);
        assertEquals(1904,l);
    }

    @Test
    public void test6(){
        List<Linje> linjer = map.get(6);

        long l = new Silly().lagKvadrater(6, linjer);
        assertEquals(4376,l);
    }

    @Test
    public void test10(){
        List<Linje> linjer = map.get(10);

        long l = new Silly().lagKvadrater(10, linjer);
        assertEquals(76976,l);
    }



    @Test
    public void test18(){
        List<Linje> linjer = map.get(18);

        long l = new Silly().lagKvadrater(18, linjer);
        assertEquals(766736,l);
    }

}