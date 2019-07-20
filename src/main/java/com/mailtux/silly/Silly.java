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

          for (int i=0;i<lister.size();i++) {
              Long start=System.nanoTime();
              List<Linje> linjer = lister.get(i);
              System.out.println("Nummer "+i+" "+linjer.size());

              lagKvadrater(linjer);
              System.out.println((System.nanoTime() - start)/1000000000);
          }

    }

    private void lagKvadrater(List<Linje> linjer) {

        List<Kvadrat> kvadrater = new ArrayList<>();
        linjer.stream().forEach(x -> {
            linjer.stream().forEach(y -> {
                linjer.stream().forEach(z -> {
                    linjer.stream().forEach(w -> {
                        kvadrater.add(new Kvadrat(x, y, z, w));

                    });

                });
            });


        });

        System.out.println("Antall mulige: "+kvadrater.size());
             List<Kvadrat> riktige=new ArrayList<>();
        AtomicLong antall = new AtomicLong();
        kvadrater.stream().forEach(x -> {
            if (sjekk(x)) {
                antall.incrementAndGet();
                riktige.add(x) ;
            }


        });
        System.out.println("Antall riktige: "+riktige.size());

    }

    private boolean sjekk(Kvadrat kvadrat) {
        Linje første = kvadrat.getFørste();
        Linje andre = kvadrat.getAndre();
        Linje tredje = kvadrat.getTredje();
        Linje fjerde = kvadrat.getFjerde();


        int sum = første.getSum();
        if ((første.getL1() + andre.getL1() + tredje.getL1() + fjerde.getL1()) != sum) {
            return false;
        }

        if ((første.getL2() + andre.getL2() + tredje.getL2() + fjerde.getL2()) != sum) {
            return false;
        }

        if ((første.getL3() + andre.getL3() + tredje.getL3() + fjerde.getL3()) != sum) {
            return false;
        }

        if ((første.getL4() + andre.getL4() + tredje.getL4() + fjerde.getL4()) != sum) {
            return false;
        }

        if ((første.getL1() + andre.getL2() + tredje.getL3() + fjerde.getL4()) != sum) {
            return false;
        }

        if ((første.getL4() + andre.getL3() + tredje.getL2() + fjerde.getL1()) != sum) {
            return false;
        }

        return true;

    }
}
