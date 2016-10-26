/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf2a1.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Jaume
 */
public class Exercici3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * A una farmàcia es posa un display on aniran sortint diferents frases
         * sobre la salut. “Hidrata’t bé”, “Beu dos litres d’aigua al dia”,
         * “Camina 5km cada dia”, “Fes esport diàriament”, “Menja 5 peces de
         * fruita al dia”, etc. Per fer-ho hem de fer una aplicació que
         * utilitzant la interfície ExecutorService ens mostri un missatge per
         * pantalla amb una frase de les anteriors. El missatge s’ha d’extreure
         * d’un array d’strings de forma aleatòria. L’aparició del primer
         * missatge s’ha de produir de forma immediata quan executem l’aplicació
         * i després s’ha d’anar mostrant cada 5 segons durant 1 minut. Podem
         * crear un pool únic (newSingleThreadSch eduledExecutor()).
         */

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        final List<Fils> llistaTasques = new ArrayList();
       

      

            Fils calcula = new Fils(1);
            llistaTasques.add(calcula);

        

      
     
            Future<?> future = executor.scheduleWithFixedDelay(llistaTasques.get(0), 0, 5, TimeUnit.SECONDS);
        

    }

    
   
    public static class Fils implements Runnable {

        private final List<String> misatjes = new ArrayList();
      
       
        private int numero;

        public Fils(int numero) {
            this.numero = numero;
        
        misatjes.add("Hidrata’t bé");
        misatjes.add("Beu dos litres d’aigua al dia");
        misatjes.add("Camina 5km cada dia");
        misatjes.add("Fes esport diàriament");
        misatjes.add("Menja 5 peces de fruita al dia");
        }

        @Override
        public void run() {
             Random rand = new Random();
        int randomNum = rand.nextInt((5 - 0) + 1) + 0;
            for (int i = 0; i <1; i++) {
                System.out.println(misatjes.get(randomNum));
            }
        }

    }
}
