package com.mailtux.silly;

import java.util.List;
import java.util.Map;

public class Silly {
    public static void main(String[] args) {


        new Silly().doit();


    }

    private static boolean sjekk(Linje første, Linje andre, Linje tredje, Linje fjerde) {
        int sum = første.sum;
        if ((første.l1 + andre.l1 + tredje.l1 + fjerde.l1) != sum) {
            printItFeil(første,andre,tredje,fjerde,1);

            return false;
        }

        if ((første.l2 + andre.l2 + tredje.l2 + fjerde.l2) != sum) {
              printItFeil(første,andre,tredje,fjerde,2);

            return false;
        }

        if ((første.l3 + andre.l3 + tredje.l3 + fjerde.l3) != sum) {
            printItFeil(første,andre,tredje,fjerde,3);

            return false;
        }

        if ((første.l4 + andre.l4 + tredje.l4 + fjerde.l4) != sum) {
            printItFeil(første,andre,tredje,fjerde,4);

            return false;
        }

        if ((første.l1 + andre.l2 + tredje.l3 + fjerde.l4) != sum) {
            printItFeil(første,andre,tredje,fjerde,5);

            return false;
        }

        if ((første.l4 + andre.l3 + tredje.l2 + fjerde.l1) != sum) {
            printItFeil(første,andre,tredje,fjerde,6);

            return false;
        }

        printIt(første,andre,tredje,fjerde);

        return true;

    }

    private static void printIt(Linje første, Linje andre, Linje tredje, Linje fjerde) {
        if(true)return;
        System.out.println(første.l1+" "+første.l2+" "+første.l3+" "+første.l4);
        System.out.println(andre.l1+" "+andre.l2+" "+andre.l3+" "+andre.l4);
        System.out.println(tredje.l1+" "+tredje.l2+" "+tredje.l3+" "+tredje.l4);
        System.out.println(fjerde.l1+" "+fjerde.l2+" "+fjerde.l3+" "+fjerde.l4);
        System.out.println();
    }

    private static void printItFeil(Linje første, Linje andre, Linje tredje, Linje fjerde,int test) {
        if (true) return;
        System.out.println(første.l1+" "+første.l2+" "+første.l3+" "+første.l4+"     f"+test);
        System.out.println(andre.l1+" "+andre.l2+" "+andre.l3+" "+andre.l4+"     f"+test);
        System.out.println(tredje.l1+" "+tredje.l2+" "+tredje.l3+" "+tredje.l4+"     f"+test);
        System.out.println(fjerde.l1+" "+fjerde.l2+" "+fjerde.l3+" "+fjerde.l4+"     f"+test);
        System.out.println();
    }

    private void doit() {

        Map<Integer, List<Linje>> lister = new LagLister().lagLister();

       // long startTotal = System.nanoTime();
        for (int i = 0; i < lister.size(); i++) {
            Long start = System.nanoTime();
            List<Linje> linjer = lister.get(i);
         //   System.out.println("Nummer " + i + " " + linjer.size());

            lagKvadrater(i, linjer);
            //    System.out.println("Tid denne: " + (System.nanoTime() - start) / 1000000000.0);
            //    System.out.println("Tid akkumulert: " + (System.nanoTime() - startTotal) / 1000000000.0);

        }
     //   System.out.println("Totaltid: " + (System.nanoTime() - startTotal) / 1000000000.0);


    }

    public long lagKvadrater(int i, List<Linje> linjer) {

        Teller antallOk = new Teller();
        Teller antallTestet = new Teller();

     //   long start = System.nanoTime();

        linjer.stream().forEach(x -> {
            linjer.stream().forEach(y -> {
                linjer.stream().forEach(z -> {
                    linjer.stream().forEach(w -> {
                        if (sjekk(x, y, z, w)) {
                            antallOk.add();
                            antallTestet.add();
                        } else {
                            antallTestet.add();
                        }
                    });
                });
            });
        });
        System.out.println(i + "\t" + linjer.size() + "\t"+antallTestet.get()+"\t"+antallOk.get());
      //  System.out.println("Totaltid: " + (System.nanoTime() - start) / 1000000000.0);

        return antallOk.get();

    }
}
