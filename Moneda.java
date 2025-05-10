import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.desktop.AboutEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Moneda {

    private double cantidad;
    private Map<String , Double> mapaMoneda;

    public  Moneda(){}

    public Moneda(String cantidad,  Map<String , Double> mapaMoneda){
        this.cantidad = Double.parseDouble(cantidad);
        this.mapaMoneda = mapaMoneda;
    }
    public Moneda(RecordApiCambio record) {
        this.mapaMoneda = record.conversion_rates();
    }

    public double getCantidad() {
        return cantidad;
    }

    public Map<String, Double> getMapaMoneda(){
        return mapaMoneda;
    }

    public double realizarConversion(double cantidad, double monedaDeOrigen, double monedaDeDestino){
        return cantidad / monedaDeOrigen * monedaDeDestino;
//        double cantidadARS = 1000;
//        double tasaARS = moneda.getMapaMoneda().get("ARS");
//        double tasaEUR = moneda.getMapaMoneda().get("EUR");
//        double resultado = cantidadARS / tasaARS * tasaEUR;
//        System.out.println("1000 ARS equivale a " + resultado + " EUR");
    }

    @Override
    public String toString() {
        return  "Mapa de tipos de Monedas: " + getMapaMoneda().entrySet();
    }
}

