package com.mailtux.silly;

import java.util.List;
import java.util.Map;

public class SillyTo {
    public static void main(String[] args) {


        new SillyTo().doit();


    }

    private static boolean sjekk(Linje første, Linje førsteNed, Linje andreNed, Linje tredjeNed,Linje fjerdeNed) {

        int sum = første.sum;
        if ((førsteNed.l2+andreNed.l2+tredjeNed.l2+fjerdeNed.l2) != sum) {
            return false;
        }

        if ((førsteNed.l3+andreNed.l3+tredjeNed.l3+fjerdeNed.l3) != sum) {
            return false;
        }

        if ((førsteNed.l4+andreNed.l4+tredjeNed.l4+fjerdeNed.l4) != sum) {
            return false;
        }

        if ((første.l1+andreNed.l2+tredjeNed.l3+fjerdeNed.l4) != sum) {
            return false;
        }

        if ((førsteNed.l4+andreNed.l3+tredjeNed.l2+første.l4) != sum) {
            return false;
        }

        printIt(første,førsteNed,andreNed,tredjeNed,fjerdeNed);



        return true;

    }

    private static void printIt(Linje første, Linje førsteNed, Linje andreNed, Linje tredjeNed, Linje fjerdeNed) {
        if (true) return;
        System.out.println(første.l1+" "+første.l2+" "+første.l3+" "+første.l4);
        System.out.println(førsteNed.l2+" "+andreNed.l2+" "+tredjeNed.l2+" "+fjerdeNed.l2);
        System.out.println(førsteNed.l3+" "+andreNed.l3+" "+tredjeNed.l3+" "+fjerdeNed.l3);
        System.out.println(førsteNed.l4+" "+andreNed.l4+" "+tredjeNed.l4+" "+fjerdeNed.l4);
        System.out.println();


    }

    private void doit() {

        Map<Integer, List<Linje>> lister = new LagLister().lagLister();
        Map<LagIndekserteLister.ListeIndex, List<Linje>> indekserteLister = new LagIndekserteLister().lagLister();

        long startTotal = System.nanoTime();
        for (int i = 0; i < lister.size(); i++) {
            Long start = System.nanoTime();
            List<Linje> linjer = lister.get(i);
         //   System.out.println("Nummer " + i + " " + linjer.size());

            lagKvadrater(i, linjer,indekserteLister);
            //    System.out.println("Tid denne: " + (System.nanoTime() - start) / 1000000000.0);
            //    System.out.println("Tid akkumulert: " + (System.nanoTime() - startTotal) / 1000000000.0);

        }
        System.out.println("Totaltid: " + (System.nanoTime() - startTotal) / 1000000000.0);


    }

    public long lagKvadrater(int i, List<Linje> linjer, Map<LagIndekserteLister.ListeIndex, List<Linje>> indekserteLister) {

        Teller antallOk = new Teller();
        Teller antallTestet = new Teller();

        linjer.stream().forEach(x -> {
                    List<Linje> linjer1 = indekserteLister.get(new LagIndekserteLister.ListeIndex(i, x.l1));
                    List<Linje> linjer2 = indekserteLister.get(new LagIndekserteLister.ListeIndex(i, x.l2));
                    List<Linje> linjer3 = indekserteLister.get(new LagIndekserteLister.ListeIndex(i, x.l3));
                    List<Linje> linjer4 = indekserteLister.get(new LagIndekserteLister.ListeIndex(i, x.l4));
                    linjer1.stream().forEach(y1 -> {
                        linjer2.stream().forEach(y2 -> {
                            linjer3.stream().forEach(y3 -> {
                                linjer4.stream().forEach(y4 -> {
                                    if (sjekk(x, y1, y2, y3, y4)) {
                                        antallOk.add();
                                        antallTestet.add();
                                    } else {
                                        antallTestet.add();

                                    }
                                    ;
                                });

                            });
                        });
                    });
                });


        System.out.println(i + "\t" + linjer.size() + "\t"+antallTestet.get()+"\t"+antallOk.get());
        return antallOk.get();

    }
}
