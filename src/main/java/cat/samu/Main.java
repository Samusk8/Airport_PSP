package cat.samu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner sc = new Scanner(System.in);

    static void main() {
        try {
            int nAviones = Airport.askAviones();
            int nPistas = Airport.askPistas();
            System.out.println(nAviones + " " + nPistas);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
