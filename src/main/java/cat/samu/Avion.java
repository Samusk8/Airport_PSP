package cat.samu;


import java.util.Random;

public class Avion extends Thread {
    private String code;
    private Estado state;
    private TorreControl torre;

    public Avion(String code, Estado state,  TorreControl torre) {
        this.code = code;
        this.state = state;
        this.torre = torre;
    }

    public String getCode() {
        return code;
    }
    /*public void setCode(String code) {
        this.code = code;
    }*/
    public synchronized Estado getEstado() {
        return state;
    }
    public synchronized void setState(Estado state) {
        this.state = state;
    }

    public void run() {
        try{
            //double m = Math.random();
            int random;
            /*switch (state) {
                case EN_ESPERA:
                    Thread.sleep(random = numerorandom());
                    //torre.solicitarDespegue();
                    despegar();
                    break;
                case DESPEGANDO:
                    despegar();
                    break;
                case VOLANDO:
                    Thread.sleep(random = numerorandom());
                    torre.solicitarAterrizaje();
                    aterrizar();
                    break;
                case ATERRIZANDO:
                    aterrizar();
                    break;
                default:
                    break;
            }*/
            if(state == Estado.EN_ESPERA){
                Thread.sleep(numerorandom());
                despegar();
            }
            if (state == Estado.VOLANDO) {
                Thread.sleep(numerorandom());
                aterrizar();
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }

    public int numerorandom() {
        Random r = new Random();
        return r.nextInt((5000-1000)+1)+1000;
    }

    public void aterrizar() throws InterruptedException {
        int pista = -1;
        while(pista == -1) {
            pista = torre.solicitarAterrizaje();
            if(pista == -1){
                Thread.sleep(500);
            }
        }
        setState(Estado.ATERRIZANDO);
        Thread.sleep(numerorandom());
        torre.liberarPista(pista);
        setState(Estado.EN_TERMINAL);

    }

    public void despegar() throws InterruptedException {
        int pista = torre.solicitarAterrizaje();
        setState(Estado.DESPEGANDO);
        Thread.sleep(numerorandom());
        torre.liberarPista(pista);
        setState(Estado.VOLANDO);
    }
}
