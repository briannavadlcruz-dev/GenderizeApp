import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenderPredictor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- PREDICTOR DE GÉNERO (Probabilístico) ---");
        System.out.print("Ingresa un nombre (ej. Andrea, Kevin, Alex): ");
        String nombre = scanner.next(); // Usamos .next() para tomar solo la primera palabra

        try {
            // 1. Construcción de la URL
            String url = "https://api.genderize.io/?name=" + nombre;

            // 2. Creación del Cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            System.out.println("Consultando base de datos estadística...");

            // 3. Obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                
                // 4. Parseo del JSON (Análisis de estructura)
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

                // Verificamos si la API logró identificar el nombre (si 'gender' no es nulo)
                if (!jsonObject.get("gender").isJsonNull()) {
                    
                    // Extracción de datos
                    String generoIngles = jsonObject.get("gender").getAsString();
                    double probabilidad = jsonObject.get("probability").getAsDouble();
                    int conteo = jsonObject.get("count").getAsInt();

                    // Lógica simple para traducir al español
                    String generoEspanol = generoIngles.equals("male") ? "Masculino" : "Femenino";
                    
                    // Formato de porcentaje (Matemáticas: 0.95 -> 95%)
                    int porcentaje = (int) (probabilidad * 100);

                    // 5. Mostrar resultados
                    System.out.println("\nResultados para: " + nombre.toUpperCase());
                    System.out.println("------------------------------------------------");
                    System.out.println(" Género Predicho: " + generoEspanol);
                    System.out.println(" Certeza: " + porcentaje + "%");
                    System.out.println(" Tamaño de la muestra: " + conteo + " personas");
                    System.out.println("------------------------------------------------");
                    
                    if(porcentaje < 60) {
                        System.out.println("Nota: La probabilidad es baja, el nombre podría ser unisex.");
                    }

                } else {
                    System.out.println("No pudimos determinar el género para el nombre: " + nombre);
                }

            } else {
                System.out.println("Error de conexión. Código: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        scanner.close();
    }
}