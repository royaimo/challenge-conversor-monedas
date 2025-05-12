import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Scanner;

public class Principal extends JFrame {
    Scanner entrada = new Scanner(System.in);
    DeConexionAlRecord recordConMonedas = new DeConexionAlRecord();
    Moneda moneda = new Moneda(recordConMonedas.ConvertirDeJsonAMoneda());
    Map<String, Double> mapaMoneda = moneda.getMapaMoneda();
    PanelConversor panelConversor;
    double valorMonedaLocal;
    double valorMonedaExtranjera;
    String monedaExtranjeraConversion = "";
    double cantidad = -1;


    public Principal(String titulo) {
        System.out.println(titulo);
        panelConversor = new UIConversorMonedas().getPanelConversor();
        panelConversor.inicializarCombos(mapaMoneda);

        JButton boton = panelConversor.getBoton();
        boton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("MAPA: " + mapaMoneda);
                    String monedaLocal = panelConversor.getComboMonedaLocal().getSelectedItem().toString().toUpperCase();
                    System.out.println("mon loc: " + monedaLocal);
                    String textoCantidad = panelConversor.getTxtcantidad().getText();
                    System.out.println("CANT: " + cantidad);
                    String monedaExtranjera = panelConversor.getComboMonedaExtranjera().getSelectedItem().toString().toUpperCase();
                    System.out.println("mon ext: " + monedaExtranjera);

                    if ((monedaLocal.isEmpty()) || textoCantidad.isEmpty() || (monedaExtranjera.isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados");
                        return;
                    }

                    cantidad = Double.parseDouble(textoCantidad);

                    if (!mapaMoneda.containsKey(monedaLocal)) {
                        JOptionPane.showMessageDialog(null, "Moneda LOCAL inexistente");
                        System.out.println("Esta en mapa " + mapaMoneda.containsKey(monedaLocal));
                        return;
                    } else {
                        valorMonedaLocal = mapaMoneda.get(monedaLocal);
                    }

                    if (!(cantidad >= 0)) {
                        JOptionPane.showMessageDialog(null, "Completar Cantidad: ");
                        return;
                    }

                    if (!mapaMoneda.containsKey(monedaExtranjera)) {
                        JOptionPane.showMessageDialog(null, "Moneda EXTRANJERA inexistente");
                        return;
                    } else {
                        valorMonedaExtranjera = mapaMoneda.get(monedaExtranjera);
                    }


                    double resultado = ejecutarConversion(valorMonedaLocal, cantidad, valorMonedaExtranjera);
                    JOptionPane.showMessageDialog(null, "Resultado Conversion " + resultado);

                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser numero Valido");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("Error en catch Boton");
                }
            }
        });

    }

    public double ejecutarConversion(double valorMonedaLocal, double cantidad, double valorMonedaExtranjera) {
        double conversion = cantidad / valorMonedaLocal * valorMonedaExtranjera;
        return conversion;
    }

    public Principal() { //este constructor ejecuta la app por consola

        while (true) {
            System.out.println("+++++ Realizar Conversion +++++++");

            String monedaDeOrigen = eleccionMoneda();
            double precioMonedaOrigen = ingresarMoneda(monedaDeOrigen);

            System.out.println("Ingrese la cantidad : ");
            double cantidad = entrada.nextDouble();

            String monedaDestino = eleccionMoneda();
            double precioMonedaDestino = ingresarMoneda(monedaDestino);

            double conversionFinal = moneda.realizarConversion(cantidad, precioMonedaOrigen, precioMonedaDestino);
            System.out.println("++++++ CONVERSION EXITOSA ++++++");
            System.out.printf("%s %.2f = %s %.2f \n", monedaDeOrigen, cantidad, monedaDestino, conversionFinal);

        }
    }

    private String eleccionMoneda() {
        System.out.println("Ingrese su moneda actual: DOLAr: 'USD' " +
                "PESO ARG: 'ARS' " +
                "REAL BRAZIL: 'BRL' " +
                "PESO MEXICO: 'MXN' ");

        String tipoMoneda = entrada.next().toUpperCase();

        while (!mapaMoneda.containsKey(tipoMoneda)) {
            System.out.println("La moneda " + tipoMoneda + " no existe. Ingrese una nuevamente: ");
            tipoMoneda = entrada.next().toUpperCase();
        }
        return tipoMoneda;
    }

    private double ingresarMoneda(String tipoMoneda) {
        return mapaMoneda.get(tipoMoneda);
    }


    public static void main(String[] args) {
        new Principal("Ejecutando Con panel");
    }
}

