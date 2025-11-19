package cat.samu;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Avion> aviones = new ArrayList<>();

    static void main() {
        try {
            int nAviones = Airport.askAviones();
            int nPistas = Airport.askPistas();
            System.out.println(nAviones + " " + nPistas);

            for(int i = 0; i < nAviones; i++){
                aviones.add(new Avion("IB000"+i, Estado.EN_ESPERA));
                System.out.println();
            }
            new Thread(() -> Airport.printAviones(aviones)).start();
            System.out.println(nAviones + " " + nPistas);

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
