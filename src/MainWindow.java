import com.sun.deploy.panel.JSmartTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainWindow extends Container {
    public JPanel PanelPrincipal;
    private JTextArea txtArea_cuadruplas;
    private JTextArea txtArea_descripcion;
    private JTextField txtalfabeto;
    private JTextField txtEstados;
    private JTextField txtinput;
    private JTextField txt_max_iter;
    private JButton btn_ejecutar;
    private JLabel lbl_error;
    private JScrollPane scrll_cuadruplas;
    private JScrollPane scrll_descripcion;

    public MainWindow() {
        btn_ejecutar.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //limpia los campos de salida
                lbl_error.setText("");
                txtArea_descripcion.setText("");
                txtArea_descripcion.setForeground(Color.black);


                //llena la descripcion de la maquina
                String txt_cuadruplas[] = txtArea_cuadruplas.getText().toUpperCase().split("\\n");
                ArrayList<String> desc = new ArrayList<>(Arrays.asList(txt_cuadruplas));
                Machine machine = new Machine(desc);
                //llena la cinta
                String input[] =  txtinput.getText().toUpperCase().split(",");
                ArrayList<String> inputAsArray = new ArrayList<>(Arrays.asList(input));
                machine.serCinta(inputAsArray);
                //llenar los estados
                String estados[] = txtEstados .getText().toUpperCase().split(",");
                ArrayList<String> estadosAsArray = new ArrayList<>(Arrays.asList(estados));
                machine.setConjuntoDeEstados(estadosAsArray);
                //llenar el alfabeto
                String alfabeto[] = txtalfabeto.getText().toUpperCase().split(",");
                ArrayList<String> alfabetoAsArray = new ArrayList<>(Arrays.asList(alfabeto));
                machine.setAlfabeto(alfabetoAsArray);
                String haveError = machine.checkStructure();
                //obitiene maximo numero de iteraciones
                if(!txt_max_iter.getText().isEmpty()){
                    machine.setMaxIteration(Integer.parseInt(txt_max_iter.getText()));
                }
                else {
                    machine.setMaxIteration(100000);
                }

                if(haveError.equals("")){
                    txtArea_descripcion.setText(machine.toString());
                    String result =  machine.run();
                    txtArea_descripcion.setText(result);
                    txtArea_descripcion.setForeground(Color.blue);
//                    lbl_error.setText("Check the error description above!");
//                    lbl_error.setForeground(Color.red);
                }
                else {
                    txtArea_descripcion.setText(haveError);
                    txtArea_descripcion.setForeground(Color.red);
                    lbl_error.setText("Check the error description above!");
                    lbl_error.setForeground(Color.red);
                }






            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        txtalfabeto = new JTextField();
        txtEstados = new JTextField();
        txtinput = new JTextField();
        txt_max_iter = new JTextField();
        btn_ejecutar = new JButton();
        lbl_error = new JLabel();


        scrll_cuadruplas = new JScrollPane();
        txtArea_cuadruplas = new JSmartTextArea();
        TextLineNumber ln1 = new TextLineNumber(txtArea_cuadruplas);
        scrll_cuadruplas.setRowHeaderView(ln1);
        txtArea_cuadruplas.setEditable(true);
        txtArea_cuadruplas.setFocusable(true);

        scrll_descripcion = new JScrollPane();
        txtArea_descripcion = new JSmartTextArea();
        TextLineNumber ln2 = new TextLineNumber(txtArea_descripcion);
        scrll_descripcion.setRowHeaderView(ln2);
        txtArea_descripcion.setEditable(true);
        txtArea_descripcion.setFocusable(true);


    }
}
