import java.util.ArrayList;

public class Machine {
    private Cinta cinta;
    private ArrayList<String> conjuntoDeEstados;
    private ArrayList<String> alfabeto;
    private ArrayList<Cuadrupla> machineDescription = new ArrayList<>();
    private int maxIteration = 100000;

    private int pointerToState = 0;
    private int pointerCinta = 0;


    public Machine(ArrayList<String>  cuadruplas) {
        for (String cuadrup: cuadruplas){
            String parts[] = cuadrup.split(",");
            Cuadrupla c = new Cuadrupla(parts[0],parts[1],parts[2],parts[3]);
            machineDescription.add(c);
        }
    }

    public void serCinta(ArrayList<String > input){
        cinta = new Cinta(input);
    }
    public void setConjuntoDeEstados(ArrayList<String> conjuntoDeEstados){
        this.conjuntoDeEstados =  conjuntoDeEstados;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }


    public void moveHeadRight(){
        pointerCinta ++;
        cinta.Read(pointerCinta);
    }

    public void moveHeadLeft(){
        pointerCinta --;
        cinta.Read(pointerCinta);
    }

    public int getMaxIteration() {
        return maxIteration;
    }

    public void setMaxIteration(int maxIteration) {
        this.maxIteration = maxIteration;
    }

    public String checkStructure(){
         String errorMsj = "";
         //revisar que la cinta solo tiene  elemntos del alfabeto
        for (Casilla c: cinta.getElemts().values()){
            if(!alfabeto.contains(c.getSimbolo()) && !c.getSimbolo().equals("@")){
                errorMsj += "Error: symbol not in alphabet---> " + c.getSimbolo()+ "\n";
            }
        }

         for (Cuadrupla c: machineDescription){
                String origen = c.getEstadoOrigen();
                String simbolo = c.getSimboloRequerido();
                String operacion = c.getSimboloOperacion();
                String destino = c.getEstadoDestino();
                if(!conjuntoDeEstados.contains(origen)){
                    errorMsj += "Error: invalid start state---> " + origen +" on: " + c.toString()+"\n";
                }
                if(!conjuntoDeEstados.contains(destino)){
                    errorMsj += "Error: invalid end state---> " + destino +" on: " + c.toString()+"\n";
                }
                if(!alfabeto.contains(simbolo) && !simbolo.equals("@")){
                    errorMsj += "Error: symbol not in alphabet---> " + simbolo + " on: "+ c.toString()+"\n";
                }
                if(!operacion.equals("L") && !operacion.equals("R") && !operacion.equals("@") && !alfabeto.contains(operacion)){
                    errorMsj += "Error: symbol is not a valid operation--->" + operacion + " on: "+ c.toString()+"\n";
                }

         }
         return errorMsj;
    }

    public String run(){
        String errorMsj = "";
        String output = "\tStart:\t\n"+toString();
        boolean bool = true;
        int count = 0;

        while (bool){
            int noOption = 0;
            for (Cuadrupla c: machineDescription){
                String origen = c.getEstadoOrigen();
                String simbolo = c.getSimboloRequerido();
                String operacion = c.getSimboloOperacion();
                String destino = c.getEstadoDestino();
                //busca que exita una combinacion de estao e imput
                if(origen.equals(conjuntoDeEstados.get(pointerCinta)) && simbolo.equals(cinta.Read(pointerCinta))){
                    if(operacion.equals("R")){
                        //mover cabezal
                        moveHeadRight();
                        //determinar destino y colocar pointer hacia el
                        pointerToState = conjuntoDeEstados.indexOf(destino);
                        output += toString();
                        noOption = 0;
                    }
                    else if(operacion.equals("L")){
                        //mover cabezal
                        moveHeadLeft();
                        //determinar destino y colocar pointer hacia el
                        pointerToState = conjuntoDeEstados.indexOf(destino);
                        output += toString();
                        noOption = 0;
                    }
                    else if(operacion.equals("@")){
                        //escribir blanco en cinta
                        cinta.Write(pointerCinta, "@");
                        //determinar destino y colocar pointer hacia el
                        pointerToState = conjuntoDeEstados.indexOf(destino);
                        output += toString();
                        noOption = 0;
                    }
                    else {
                        //escribir simbolo en cinta
                        cinta.Write(pointerCinta,simbolo);
                        //determinar destino y colocar pointer hacia el
                        pointerToState = conjuntoDeEstados.indexOf(destino);
                        output += toString();
                        noOption = 0;
                    }

                }
                //de lo contrario marca que se acabo
                else {
                    noOption = 1;
                }

            }
            count = count + 1;
            if(noOption == 1&& count == maxIteration){
                output +=  "Success!!";
                return output;
            }
            //loop breaker
            if(count >= maxIteration){
                bool = false;
                errorMsj += "Error: INFINITE LOOP DETECTED!!!\n, simulation passed over 100,000 iterations!\n";
                return errorMsj;
            }

        }
        //no debe de pasar
        return  null;
    }

    @Override
    public String toString() {
        String result  = "----Inst. Desc.----\n";
        result += "Current State:..... [" + conjuntoDeEstados.get(pointerToState)+"]\n";
        result += "Head position:..... " + pointerCinta + "\n";
        result += "tape:..... [" + cinta.toString() +"]\n";
        result += "Symbol under head:..... [" + cinta.Read(pointerCinta)+"]\n";

        return result;
    }
}
