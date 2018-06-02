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
    private JTextField textField4;
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
                Machine machine = new Machine();
                //llena la cinta
                String input[] =  txtinput.getText().split(",");
                ArrayList<String> inputAsArray = new ArrayList<>(Arrays.asList(input));
                machine.serCinta(inputAsArray);



            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        txtalfabeto = new JTextField();
        txtEstados = new JTextField();
        txtinput = new JTextField();
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
