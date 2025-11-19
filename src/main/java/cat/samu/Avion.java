package cat.samu;


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
            double m = Math.random();

        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
}
