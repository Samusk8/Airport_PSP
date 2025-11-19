package cat.samu;

import java.util.concurrent.locks.ReentrantLock;

public class TorreControl {
    //private int nPistas;
    private ReentrantLock[] pistas;
    //private boolean[] pistaslibres;

    //private ReentrantLock controlLock = new ReentrantLock();


    public TorreControl(int nPistas) {
        //this.nPistas = nPistas;
        pistas  = new ReentrantLock[nPistas];
        //pistaslibres = new boolean[nPistas];
        for(int i = 0; i < nPistas; i++){
            pistas[i] = new ReentrantLock(true);
            //pistaslibres[i] = true;
        }
    }

    public int solicitarAterrizaje(){
        while(true){
            for (int i = 0; i < pistas.length; i++) {
                if (pistas[i].tryLock()) {
                    System.out.println("la pista "+ pistas[i].toString()+" esta bloqueada");
                    return i;
                }
            }
            //System.out.println("pistas libres"+pistas.toString());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void liberarPista(int pista){
        //controlLock.lock();
        pistas[pista].unlock();
        System.out.println("la pista "+ pistas[pista].toString()+" esta libre");
        try{
            //pistaslibres[pista] = true;
        } finally{
            //controlLock.unlock();
        }
    }

    /*public int buscarpistaLibre(){
        for (int i = 0; i < pistaslibres.length; i++) {
            if(pistaslibres[i] == true){
                return i;
            }
        }
        return -1;
    }*/
}
