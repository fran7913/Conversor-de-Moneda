import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda convertir = new ConversorDeMoneda();
        int opcionEscogida = 0;

        while (opcionEscogida != 9) {
            try {
                System.out.println("""
                    *****************************************
                    Bienvenido/a al Conversor de Moneda.

                    1) Dólar => Peso argentino
                    2) Peso argentino => Dólar
                    3) Dólar => Real brasilero
                    4) Real brasilero => Dólar
                    5) Dólar => Peso Mexiano
                    6) Peso Mexicano => Dólar
                    7) Dólar => Peso colombiano
                    8) Peso colombiano => Dólar
                    9) Salir
                    *****************************************
                    Elija una opción:
                """);

                opcionEscogida = scanner.nextInt();

                if (opcionEscogida >= 1 && opcionEscogida <= 8) {
                    System.out.print("Por favor ingrese la cantidad a convertir: ");
                    double cantidad = scanner.nextDouble();
                    // valida si la cantidad sea positiva
                    if (cantidad < 0){
                        System.out.println("La cantidad debe ser un numero positivo");
                        continue; // vuelve la inicio del bucle
                    }
                    convertir.convertir(opcionEscogida, cantidad);
                } else if (opcionEscogida == 9) {
                    System.out.println("Gracias por utilizar nuestro conversor. ¡Hasta pronto!");
                } else {
                    System.out.println("Opción no válida. Intentelo de  nuevo.");
                }

                System.out.println("------------------------------------------");
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // limpia el buffer
            }
        }

        scanner.close();
    }
}
