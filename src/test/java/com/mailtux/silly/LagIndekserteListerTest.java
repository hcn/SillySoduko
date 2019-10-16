package com.mailtux.silly;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LagIndekserteListerTest {

    @Test
    public void lageLister(){

        Map<LagIndekserteLister.ListeIndex, List<Linje>> lister = new LagIndekserteLister().lagLister();

        assertEquals(280,lister.size());

    }



}