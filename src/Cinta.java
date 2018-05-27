import java.util.HashMap;

public class Cinta {

    private HashMap<Integer,Casilla> casillas = new HashMap<Integer, Casilla>();

    public Cinta(){}

    public HashMap<Integer, Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(HashMap<Integer, Casilla> casillas) {
        this.casillas = casillas;
    }
}
