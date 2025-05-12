import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApiCambio {

    public String ConectarApiCambio(){

        try(HttpClient client = HttpClient.newHttpClient()) {
            String direccionApiCambio ="https://v6.exchangerate-api.com/v6/6f19a3860da61942db10e5e2/latest/USD";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccionApiCambio))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("L21 - Error En catch ConexionApiCambio");
        }
        return null;
    }
}
