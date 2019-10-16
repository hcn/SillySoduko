package com.mailtux.silly;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LagIndekserteLister {

    public Map<ListeIndex, List<Linje>>  lagLister(){
        List<Linje> linjer=new ArrayList<Linje>();
        for (int i=0;i<=9999;i++){
            linjer.add(new Linje(i));
        }
        Map<ListeIndex, List<Linje>> result =
                linjer.stream().collect(Collectors.groupingBy(x->new ListeIndex(x.getSum(),x.getForste())));

        return result;
    }

    public static class ListeIndex {

        @Override
        public int hashCode() {
            return Objects.hash(sum, forste);
        }

        @Override
        public boolean equals(Object o) {
            ListeIndex l=(ListeIndex)o;
            return this.sum==l.getSum() && this.forste==l.forste;
        }

        private int sum;
        private int forste;
        public ListeIndex(int sum,int forste) {
            this.sum=sum;
            this.forste=forste;
        }

        public int getSum() {
            return sum;
        }

        public int getForste() {
            return forste;
        }
    }

}
