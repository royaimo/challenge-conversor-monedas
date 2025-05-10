import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DeConexionAlRecord {

    public RecordApiCambio ConvertirDeJsonAMoneda(){
        try {
            //LLamada a la API Exchange
            ConexionApiCambio conexion = new ConexionApiCambio();
            //Leer la respuesta JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            RecordApiCambio recordApiCambio = gson.fromJson(conexion.ConectarApiCambio(), RecordApiCambio.class);

            return recordApiCambio;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("L17 - Error en catch DeConexionAlRecordYaMoneda");
        }
        return null;
    }
}
