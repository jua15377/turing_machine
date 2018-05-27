public class Casilla{

    private int indice;
    private String simbolo;
    private boolean isRigthEdge;
    private boolean isLeftEdge;

    public Casilla(int indice, String simbolo){
        this.indice = indice;
        this.simbolo = simbolo;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
