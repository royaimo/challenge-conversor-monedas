import javax.swing.*;
import java.awt.*;

public class UIConversorMonedas extends JFrame {

    private PanelConversor panelConversor;

    public UIConversorMonedas(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CONVERSOR DE MONEDAS");
        setBounds(1000,000,500,300);

        panelConversor = new PanelConversor();
        add(panelConversor);

        setVisible(true);
    }

    public PanelConversor getPanelConversor() {
        return panelConversor;
    }

    public static void main(String[] args) {
        new UIConversorMonedas();
    }
}
