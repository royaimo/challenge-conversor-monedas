import javax.swing.*;
import java.awt.*;
import java.util.Map;

class PanelConversor extends JPanel {

    JLabel labelMonedaLocal = new JLabel("Ingrese moneda local");
    JComboBox<String> comboMonedaLocal = new JComboBox<>();
    JTextField txtcantidad = new JTextField(10);
    JComboBox<String> comboMonedaExtranjera = new JComboBox<>();
    JLabel labelcantidad = new JLabel("Cantidad");
    JLabel labelMonedaExtranjera = new JLabel("Ingrese moneda extranjera");
    JButton boton = new JButton("CONVERTIR");

    public PanelConversor() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 15, 15);//margen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        agregarComponente(0, 0, labelMonedaLocal, gbc);
        labelMonedaLocal.setFont(new Font(null, Font.BOLD, 16));
        agregarComponente(1, 0, comboMonedaLocal, gbc);
        comboMonedaLocal.setFont(new Font(null, Font.PLAIN, 16));
        agregarComponente(0, 1, labelcantidad, gbc);
        labelcantidad.setFont(new Font(null, Font.BOLD, 16));
        agregarComponente(1, 1, txtcantidad, gbc);
        txtcantidad.setFont(new Font(null, Font.PLAIN, 16));
        agregarComponente(0, 2, labelMonedaExtranjera, gbc);
        labelMonedaExtranjera.setFont(new Font(null, Font.BOLD, 16));
        agregarComponente(1, 2, comboMonedaExtranjera, gbc);
        comboMonedaExtranjera.setFont(new Font(null, Font.PLAIN, 16));
        gbc.gridwidth = 2;//boton tomara 2 col.
        gbc.fill = GridBagConstraints.NONE;
        boton.setPreferredSize(new Dimension(200, 40));
        agregarComponente(0, 3, boton, gbc);
        gbc.gridwidth = 1;//volvemos a que los demas obj tomen 1
        setBackground(Color.lightGray);

    }

    public void agregarComponente(int posX, int posY, Component objeto, GridBagConstraints gbc) {
        gbc.gridx = posX;
        gbc.gridy = posY;
        add(objeto, gbc);
    }

    public void inicializarCombos(Map<String,Double> mapaMoneda){
        for(String elementos : mapaMoneda.keySet()){
            comboMonedaLocal.addItem(elementos);
            comboMonedaExtranjera.addItem(elementos);
        }
    }

    public JComboBox<String> getComboMonedaLocal() {
        return comboMonedaLocal;
    }

    public void setComboMonedaLocal(JComboBox comboMonedaLocal) {
        this.comboMonedaLocal = comboMonedaLocal;
    }

    public JTextField getTxtcantidad() {
        return txtcantidad;
    }

    public void setTxtcantidad(JTextField txtcantidad) {
        this.txtcantidad = txtcantidad;
    }

    public JComboBox getComboMonedaExtranjera() {
        return comboMonedaExtranjera;
    }

    public void setComboMonedaExtranjera(JComboBox comboMonedaExtranjera) {
        this.comboMonedaExtranjera = comboMonedaExtranjera;
    }

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }
}



