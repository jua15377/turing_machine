import javax.swing.*;

public class Principal {
    public static void main(String[] args){
        System.out.println("Hello turing!");
        JFrame frame = new JFrame("IdePrincipal");
        frame.setContentPane(new MainWindow().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
