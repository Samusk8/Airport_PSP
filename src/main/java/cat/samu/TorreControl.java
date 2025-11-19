package cat.samu;

import java.util.concurrent.locks.ReentrantLock;

public class TorreControl {
    //private int nPistas;
    private ReentrantLock[] pistas;
    private boolean[] pistaslibres;

    private ReentrantLock controlLock = new ReentrantLock();


    public TorreControl(int nPistas) {
        //this.nPistas = nPistas;
        pistas  = new ReentrantLock[nPistas];
        pistaslibres = new boolean[nPistas];
        for(int i = 0; i < nPistas; i++){
            pistas[i] = new ReentrantLock();
            pistaslibres[i] = true;
        }
    }

    public int solicitarAterrizaje(){
        while(true){
            controlLock.lock();
            try{
                int pista = buscarpistaLibre();
                if (pista >= 0){
                    pistaslibres[pista] = false;
                    return pista;
                }
            } finally{
                controlLock.unlock();
            }
        }
    }

    public void liberarPista(int pista){
        controlLock.lock();
        try{
            pistaslibres[pista] = true;
        } finally{
            controlLock.unlock();
        }
    }

    public int buscarpistaLibre(){
        for (int i = 0; i < pistaslibres.length; i++) {
            if(pistaslibres[i] == true){
                return i;
            }
        }
        return -1;
    }
}
