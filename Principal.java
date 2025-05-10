import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class Principal extends  JFrame{
    Scanner entrada = new Scanner(System.in);
    DeConexionAlRecord recordConMonedas = new DeConexionAlRecord();
    Moneda moneda = new Moneda(recordConMonedas.ConvertirDeJsonAMoneda());
    Map<String, Double> mapaMoneda = moneda.getMapaMoneda();

    public Principal() {

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
            System.out.printf("%s %.2f = %s %.2f \n",monedaDeOrigen, cantidad, monedaDestino, conversionFinal);

        }
    }

    private String eleccionMoneda() {
        System.out.println("Ingrese su moneda actual: DOLAr: 'USD' " +
                "PESO ARG: 'ARS' " +
                "REAL BRAZIL: 'BRL' " +
                "PESO MEXICO: 'MXN' ");

        String tipoMoneda = entrada.next().toUpperCase();

        while(!mapaMoneda.containsKey(tipoMoneda)){
            System.out.println("La moneda " + tipoMoneda + " no existe. Ingrese una nuevamente: ");
            tipoMoneda = entrada.next().toUpperCase();
        }
        return  tipoMoneda;
    }

    private double ingresarMoneda(String tipoMoneda) {
     return mapaMoneda.get(tipoMoneda);
    }


    public static void main(String[] args) {
        new Principal();
    }
}

