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

            TorreControl torre = new TorreControl(nPistas);

            for(int i = 0; i < nAviones; i++){
                Estado randomState = randomState();
                aviones.add(new Avion("IB00"+i,randomState, torre));
                System.out.println();
            }

            for (Avion a : aviones) {
                a.start();
            }

            new Thread(() -> Airport.printAviones(aviones)).start();


        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static Estado randomState(){
        Estado[] valores = Estado.values();
        int i =  (int) (Math.random()*valores.length);
        return valores[i];
    }


}
