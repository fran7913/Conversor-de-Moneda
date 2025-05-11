import Moneda.Moneda;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeMoneda {
    private final Moneda datos;
    private static final Map<Integer, String> OPCIONES_MONEDAS = new HashMap<>();

    static {
        OPCIONES_MONEDAS.put(1, "ARS"); // Peso argentino
        OPCIONES_MONEDAS.put(2, "USD"); // Dólar estadounidense
        OPCIONES_MONEDAS.put(3, "BRL"); // Real brasileño
        OPCIONES_MONEDAS.put(4, "USD"); // Dólar estadounidense
        OPCIONES_MONEDAS.put(5, "MXN"); // Peso mexicano
        OPCIONES_MONEDAS.put(6, "USD"); // Dólar estadounidense
        OPCIONES_MONEDAS.put(7, "COP"); // Peso colombiano
        OPCIONES_MONEDAS.put(8, "USD"); // Dólar estadounidense
    }

    public ConversorDeMoneda() {
        this.datos = new LlamarApi().obtenerDatosMoneda();
    }

    public void convertir(int opcion, double cantidad) {
        if (datos == null) {
            System.out.println("No se pudo obtener datos de la API.");
            return;
        }

        String monedaDestino = OPCIONES_MONEDAS.get(opcion);
        if (monedaDestino == null) {
            System.out.println("Opción no válida.");
            return;
        }

        boolean desdeUsd = (opcion % 2 != 0); // Impares: USD => Otro
        try {
            double tasa = obtenerTasa(desdeUsd, monedaDestino, opcion);
            double resultado = cantidad * tasa;
            String desde = desdeUsd ? "USD" : getCodigoLocal(opcion);
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, desde, resultado, monedaDestino);
        } catch (NullPointerException e) {
            System.out.println("Error: tasa de conversión no disponible para la moneda seleccionada.");
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero.");
        }
    }

    private double obtenerTasa(boolean desdeUsd, String monedaDestino, int opcion) {
        if (desdeUsd) {
            return datos.getConversion_rates().get(monedaDestino);
        } else {
            return 1 / datos.getConversion_rates().get(getCodigoLocal(opcion));
        }
    }

    private String getCodigoLocal(int opcion) {
        return switch (opcion) {
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "MXN";
            case 8 -> "COP";
            default -> "USD";
        };
    }
}
