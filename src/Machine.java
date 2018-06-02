import java.util.ArrayList;

public class Machine {
    private Cinta cinta;
    private ArrayList<String> conjuntoDeEstados;
    private int pointerToState = 0;
    private int pointerCinta = 0;


    public Machine() {
    }

    public void serCinta(ArrayList<String > input){
        cinta = new Cinta(input);
    }
    public void setConjuntoDeEstados(ArrayList<String> conjuntoDeEstados){
        this.conjuntoDeEstados =  conjuntoDeEstados;
    }
    public void stateForward(){
        pointerToState ++;
    }
    public void stateBack(){
        pointerToState --;
    }

    public void moveHeadRight(){
        pointerCinta ++;
        cinta.Read(pointerCinta);
    }

    public void moveHeadLeft(){
        pointerCinta --;
        cinta.Read(pointerCinta);
    }

}
