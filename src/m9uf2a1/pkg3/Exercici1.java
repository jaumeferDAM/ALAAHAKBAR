/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf2a1.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Jaume
 */
public class Exercici1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        List<Fils> llistaTasques = new ArrayList();

        for (int i = 0; i < 100; i++) {

            Fils calcula = new Fils(i);
            llistaTasques.add(calcula);
        }

        List<Future<Integer>> llistaResultats = new ArrayList<>();

        for (int i = 0; i < llistaTasques.size(); i++) {
            Future<Integer> future = executor.submit(llistaTasques.get(i));
            llistaResultats.add(future);

        }

        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultats = llistaResultats.get(i);

            try {
                if (resultats.get() != -1) {
                    System.out.println(resultats.get());
                }

            } catch (InterruptedException | ExecutionException e) {

            }
        }

    }

    public static class Fils implements Callable {

        private int num;

        public Fils(int num) {
            this.num = num;
        }

        @Override
        public Object call() throws Exception {
            if (num % 2 == 0 && num % 3 == 0) {
                return num;
            }
            return -1;
        }

    }

}
