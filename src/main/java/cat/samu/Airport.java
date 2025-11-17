package cat.samu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airport {
    static Scanner sc = new Scanner(System.in);
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

    static void printAviones(ArrayList<Avion> aviones){
        boolean continua = true;
        while(continua){
            for(Avion avion : aviones){
                switch (avion.getEstado()){
                    case EN_ESPERA:
                        System.out.println("⌛");
                        break;
                    case DESPEGANDO:
                        System.out.println("🛫");
                        break;
                    case VOLANDO:
                        System.out.println("✈️");
                        break;
                    case ATERRIZANDO:
                        System.out.println("🛬");
                        break;
                    case EN_TERMINAL:
                        System.out.println("✅");
                        break;
                }
            }

        }
    }
}
