package cat.samu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);

    static void main() {
        try {
            int nAviones = askAviones();
            int nPistas = askPistas();
            System.out.println(nAviones + " " + nPistas);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
}
