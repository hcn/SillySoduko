package com.mailtux.silly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class Silly {
    public static void main(String[] args) {

        new Silly().doit();


    }

    private void doit() {

        Map<Integer, List<Linje>> lister = new LagLister().lagLister();

        for (int i = 2; i < 3; i++) {
            Long start = System.nanoTime();
            List<Linje> linjer = lister.get(i);
            System.out.println("Nummer " + i + " " + linjer.size());

            lagKvadrater(linjer);
            System.out.println((System.nanoTime() - start) / 1000000000.0);
        }

    }

    public long lagKvadrater(List<Linje> linjer) {

        Teller antallOk = new Teller();
        linjer.stream().forEach(x -> {
            linjer.stream().forEach(y -> {
                linjer.stream().forEach(z -> {
                    linjer.stream().forEach(w -> {
                        if (sjekk(x,y,z,w)) {
                            antallOk.add();
                        }
                    });
                });
            });
        });
        System.out.println("Antall riktige: " + antallOk.get());
        return antallOk.get();

    }

    private static boolean sjekk(Linje første,Linje andre, Linje tredje,Linje fjerde) {
        int sum = første.sum;
        if ((første.l1+ andre.l1 + tredje.l1 + fjerde.l1) != sum) {
            return false;
        }

        if ((første.l2 + andre.l2+ tredje.l2 + fjerde.l2) != sum) {
            return false;
        }

        if ((første.l3 + andre.l3 + tredje.l3 + fjerde.l3) != sum) {
            return false;
        }

        if ((første.l4 + andre.l4 + tredje.l3 + fjerde.l4) != sum) {
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
