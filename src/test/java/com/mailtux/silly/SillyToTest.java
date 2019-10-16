package com.mailtux.silly;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SillyToTest {

    private static Map<Integer, List<Linje>> map;
    private static Map<LagIndekserteLister.ListeIndex, List<Linje>> indeksertMap;

    @BeforeClass
    public static void before(){
        Map<Integer, List<Linje>> map = new LagLister().lagLister();
        Map<LagIndekserteLister.ListeIndex, List<Linje>> indeksertMap = new LagIndekserteLister().lagLister();
        SillyToTest.map=map;
        SillyToTest.indeksertMap=indeksertMap;
    }

    @Test
    public void test0(){
        List<Linje> linjer = map.get(0);

        long l = new SillyTo().lagKvadrater(0, linjer,indeksertMap);
        assertEquals(1,l);
    }

    @Test
    public void test1(){
        List<Linje> linjer = map.get(1);

        long l = new SillyTo().lagKvadrater(1, linjer,indeksertMap);
        assertEquals(8,l);
    }

    @Test
    public void test2(){
        List<Linje> linjer = map.get(2);

        long l = new SillyTo().lagKvadrater(2, linjer,indeksertMap);
        assertEquals(48,l);
    }

    @Test
    public void test3(){
        List<Linje> linjer = map.get(3);

        long l = new SillyTo().lagKvadrater(3, linjer,indeksertMap);
        assertEquals(200,l);
    }

    @Test
    public void test4(){
        List<Linje> linjer = map.get(4);

        long l = new SillyTo().lagKvadrater(4, linjer,indeksertMap);
        assertEquals(675,l);
    }

    @Test
    public void test5(){
        List<Linje> linjer = map.get(5);

        long l = new SillyTo().lagKvadrater(5, linjer,indeksertMap);
        assertEquals(1904,l);
    }

    @Test
    public void test6(){
        List<Linje> linjer = map.get(6);

        long l = new SillyTo().lagKvadrater(6, linjer,indeksertMap);
        assertEquals(4376,l);
    }

    @Test
    public void test10(){
        List<Linje> linjer = map.get(10);

        long l = new SillyTo().lagKvadrater(10, linjer,indeksertMap);
        assertEquals(76976,l);
    }

}