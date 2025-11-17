package cat.samu;


public class Avion extends Thread {
    private String code;
    private Estado state;

    public Avion(String code, Estado state) {
        this.code = code;
        this.state = state;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Estado getEstado() {
        return state;
    }
    public void setState(Estado state) {
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
