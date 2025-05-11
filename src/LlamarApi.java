import Moneda.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LlamarApi {
        public Moneda obtenerDatosMoneda() {

            String direccion = "https://v6.exchangerate-api.com/v6/d4deee5e2ffc44ba6b52edbd/latest/USD";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Verifica el codigo de estado
                if (response.statusCode() == 200) {
                    return new Gson().fromJson(response.body(), Moneda.class);
                } else {
                    System.out.println("Error en la respuesta: " + response.statusCode());
                    return null;
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
                return null;
            }
        }
    }

