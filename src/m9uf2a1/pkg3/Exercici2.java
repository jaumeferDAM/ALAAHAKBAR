 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf2a1.pkg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Jaume
 */
public class Exercici2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        List<Fils> llistaTasques = new ArrayList();
       Scanner sc=new Scanner(System.in);
       int z= sc.nextInt();
       int limite=z*1000;
        
//        for ( int i = 2 * 1000; i <= (2 * 1000) + 1000; i++) {
//            for (int k = 2000; k < (2000 + 1000); k++) {
//                Fils calcula = new Fils(i, k);
//                llistaTasques.add(calcula);
//            }
//        }
        
        for (int i = 0; i<=limite; i++) {
       
                Fils calcula = new Fils(i);
                llistaTasques.add(calcula);
         
            
        }
        
        for (int y = 0; y < llistaTasques.size(); y++) {
            Future<?> future = executor.submit(llistaTasques.get(y));
        }
    }

    public static class Fils implements Runnable {

        private int numero;
        private int contador;

        public Fils(int numero) {
            this.numero = numero;
            this.contador = contador;
        }

        @Override
        public void run() {

            for( int n=2; n<=(int) Math.sqrt(numero); n++){
         if ( numero%n == 0 ){
              System.out.println("EL numero: " + numero +" no es primo");
         }
    }
               System.out.println("EL numero: " + numero +" es primo");
        }

    }
}


