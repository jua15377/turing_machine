public class Cuadrupla {
    private String estadoOrigen;
    private String simboloRequerido;
    private String simboloOperacion;
    private String estadoDestino;

    public Cuadrupla(String qi, String si, String sj, String qj){
        estadoOrigen = qi;
        simboloRequerido = si;
        simboloOperacion = sj;
        estadoDestino = qj;
    }

    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    public String getSimboloRequerido() {
        return simboloRequerido;
    }

    public String getSimboloOperacion() {
        return simboloOperacion;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    @Override
    public String toString() {
        return "Cuadrupla{" +estadoOrigen +simboloRequerido+simboloOperacion+estadoDestino +"}";
    }
}
