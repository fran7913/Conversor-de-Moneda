# Conversor de Monedas

Este es un proyecto en Java que permite convertir montos entre distintas monedas latinoamericanas usando tasas de cambio reales obtenidas a través de una API de tipo de cambio.

## 🚀 Características

- Conversión en tiempo real entre:
  - Dólar ⇄ Peso argentino
  - Dólar ⇄ Real brasileño
  - Dólar ⇄ Peso mexicano
  - Dólar ⇄ Peso colombiano
- Validación de entrada de datos
- Manejo de errores comunes (entradas inválidas, problemas con la API)
- Interfaz simple en consola

## 🛠️ Tecnologías utilizadas

- Java 17+
- API de ExchangeRate (https://www.exchangerate-api.com)
- Gson (para parsear JSON)
- Java HTTP Client (`java.net.http.HttpClient`)

## 📁 Estructura del Proyecto

```
ConversorMoneda/
│
├── Principal.java          # Menú principal e interacción con el usuario
├── ConversorDeMoneda.java  # Lógica de conversión de monedas
├── LlamarApi.java          # Llamado a la API de tasas de cambio
├── Moneda/
│   └── Moneda.java         # Modelo de datos para deserializar respuesta JSON
```

## ✅ Cómo ejecutar

1. Clona este repositorio:
   ```bash
   https://github.com/fran7913/Conversor-de-moneda.git
   cd conversor-monedas
   ```

2. Asegúrate de tener Java 17 o superior instalado.

3. Ejecuta el proyecto desde tu IDE o mediante consola:
   ```bash
   javac -cp gson-2.10.1.jar Moneda/Moneda.java LlamarApi.java ConversorDeMoneda.java Principal.java
   java -cp .;gson-2.10.1.jar Principal
   ```

   Asegúrate de incluir el `.jar` de Gson en tu classpath.

4. ¡Listo! Ya puedes usar el conversor desde la terminal.

## 📦 Dependencias

- [Gson](https://github.com/google/gson): Librería para convertir JSON en objetos Java.
- Conexión a la API de ExchangeRate: Necesitas una [API Key gratuita](https://www.exchangerate-api.com/).

> 🔐 **Nota**: En el archivo `LlamarApi.java`, reemplaza la clave de ejemplo con tu propia API Key:

```java
String direccion = "https://v6.exchangerate-api.com/v6/TU_API_KEY_AQUI/latest/USD";
```

## 🧪 Ejemplo de uso

```text
*****************************************
Bienvenido/a al Conversor de Moneda.

1) Dólar => Peso Colombiano
...
9) Salir
*****************************************
Elija una opción:
```

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Puedes abrir un _issue_ o enviar un _pull request_ con mejoras o nuevas funcionalidades.

## Insignia
Insignia de Conversor de Moneda 

![Badge-Conversor](https://github.com/user-attachments/assets/fb6d9b15-40ba-4408-9151-715e98385889)


## 📄 Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
