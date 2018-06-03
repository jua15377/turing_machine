import java.util.ArrayList;
import java.util.HashMap;

public class Cinta {

    private HashMap<Integer,Casilla> elemts = new HashMap<Integer, Casilla>();

    public Cinta(ArrayList<String> entrada){
        int count = 0;
        for (String s:entrada) {
            Casilla c = new Casilla(count, s);
            elemts.put(count, c);
            count ++;
        }

    }

    public HashMap<Integer, Casilla> getElemts() {
        return elemts;
    }

    public void setElemts(HashMap<Integer, Casilla> elemts) {
        this.elemts = elemts;
    }

    public String Read(int index){

        if (elemts.containsKey(index)){
             return  elemts.get(index).getSimbolo();
        }
        else {
            elemts.put(index, new Casilla(index, "@"));
            return elemts.get(index).getSimbolo();
        }
    }

    public void Write(int index, String simbol){
        if(elemts.containsKey(index)){
            elemts.get(index).setSimbolo(simbol);
        }
        else {
            elemts.put(index, new Casilla(index, simbol));
        }

    }

    @Override
    public String toString() {
        String s = "";

        for(Casilla c : elemts.values()){
            s += "[" + c.getSimbolo() + "]";
        }

        return "..." + s + "..." ;
    }
}
