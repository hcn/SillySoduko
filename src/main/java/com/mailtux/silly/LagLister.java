package com.mailtux.silly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LagLister {

    public void lagLister(){
        List<Linje> linjer=new ArrayList<Linje>();
        for (int i=0;i<=9999;i++){
            linjer.add(new Linje(i));
        }
        Map<Integer, List<Linje>> result =
                linjer.stream().collect(Collectors.groupingBy(Linje::getSum));

        System.out.println();
    }
}
