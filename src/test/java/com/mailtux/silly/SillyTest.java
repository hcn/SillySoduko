package com.mailtux.silly;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SillyTest {

    private Map<Integer, List<Linje>> map;

    @Before
    public void before(){
        Map<Integer, List<Linje>> map = new LagLister().lagLister();
        this.map=map;
    }

    @Test
    public void test3(){
        List<Linje> linjer = map.get(3);

        long l = new Silly().lagKvadrater(linjer);
        assertEquals(61,l);
    }

}