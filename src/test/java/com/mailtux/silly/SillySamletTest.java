package com.mailtux.silly;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SillySamletTest {

    private static Map<Integer, List<Linje>> map;
    private static Map<LagIndekserteLister.ListeIndex, List<Linje>> indeksertMap;

    @BeforeClass
    public static void before(){
        Map<Integer, List<Linje>> map = new LagLister().lagLister();
        Map<LagIndekserteLister.ListeIndex, List<Linje>> indeksertMap = new LagIndekserteLister().lagLister();
        SillySamletTest.map=map;
        SillySamletTest.indeksertMap=indeksertMap;
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
        doit(linjer,10,76976);

    }

    @Test
    public void test18(){
        List<Linje> linjer = map.get(18);

        doit(linjer,18,766736);


    }

    private void doit(List<Linje> linjer,int antall,int mål) {
        long startto=System.nanoTime();
        long lto = new SillyTo().lagKvadrater(antall, linjer,indeksertMap);
        assertEquals(mål,lto);
        long sluttto=System.nanoTime();

        long start=System.nanoTime();
        long l = new Silly().lagKvadrater(antall, linjer);
        assertEquals(mål,l);
        long slutt=System.nanoTime();


        long tidto=sluttto-startto;
        long tid=slutt-start;
        System.out.println("Totaltid to: " + tidto / 1000000000.0);
        System.out.println("Totaltid   : " + tid / 1000000000.0);
        System.out.println("Differanse : " + (tid-tidto) / 1000000000.0);
        System.out.println("Prosent    : " + ((tidto*1.0)/(tid*1.0)) *100);
    }

}