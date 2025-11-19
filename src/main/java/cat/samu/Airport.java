package cat.samu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Airport {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Avion, Integer> combustibleMapa = new HashMap<>();

    static int askAviones(){
        int nAviones = 0;
        boolean continua = true;
        while(continua){
            System.out.println("Ingresa el número de aviones");
            System.out.println("(min 10)");
            sc = new Scanner(System.in);
            nAviones = sc.nextInt();


            if  (nAviones >= 10 ) {

                continua = false;
            }
        }
        return nAviones;

    }

    static int askPistas(){
        int nPistas = 0;
        boolean continua = true;
        while(continua){
            System.out.println("Ingresa el número de aviones");
            System.out.println("(min 2)");
            sc = new Scanner(System.in);
            nPistas = sc.nextInt();


            if  (nPistas >= 2 ) {

                continua = false;
            }
        }
        return nPistas;

    }
    //static ArrayList<Avion> aviones = new ArrayList<>();
    static void combustible(ArrayList<Avion> aviones){
        for (Avion a : aviones) {
          combustibleMapa.put(a,100);
        }
    }

    static void reducirCombustible(){
        while (true) {
            for (Avion a : combustibleMapa.keySet()) {
                if (a.getEstado() == Estado.VOLANDO){
                    Integer combustible = combustibleMapa.get(a);
                    combustibleMapa.put(a,combustible-1);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void printAviones(ArrayList<Avion> aviones){
        boolean continua = true;
        while(continua){
            System.out.println("-----------------------");
            for(Avion avion : aviones){
                Integer combustible = combustibleMapa.get(avion);
                System.out.print("["+avion.getCode()+"]");
                switch (avion.getEstado()){
                    case EN_ESPERA:
                        System.out.print("⌛");
                        System.out.println(combustible);
                        break;
                    case DESPEGANDO:
                        System.out.print("🛫");
                        System.out.println(combustible);
                        break;
                    case VOLANDO:
                        System.out.print("✈️");
                        System.out.println(combustible);
                        break;
                    case ATERRIZANDO:
                        System.out.print("🛬");
                        System.out.println(combustible);
                        break;
                    case EN_TERMINAL:
                        System.out.print("✅");
                        System.out.println(combustible);
                        break;
                }
            }
            System.out.println("-----------------------");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
