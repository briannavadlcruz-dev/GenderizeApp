## Consumo de una API: Predictor de Género (Java + API Genderize)

Este proyecto es una aplicación de consola que consume la API pública de [Genderize.io](https://genderize.io/) para determinar el género de una persona basándose en la probabilidad estadística de su nombre.

## Requisitos tecnologicos 
* **Lenguaje:** Java (JDK 11 minimo para ejecucion en consola o JDK 17 minimo para ejecucion en vs code)
* **Conexión a Internet activa** (Indispensable para consultar la API de Genderize).
* **Sistema operativo:** Windows, Linux o macOS.
* **Librería:** Google Gson 2.13.2 (Incluida en la carpeta `lib`)
* **API:** RESTful HTTP Request
* Formato de datos:JSON

## Estructura del Proyecto
* `src/`: Contiene el código fuente (`GenderPredictor.java`).
* `lib/`: Contiene la librería necesaria (`gson-2.10.1.jar`).
* `.vscode/`: Configuración automática para abrir el proyecto en Visual Studio Code.

## Instrucciones de ejecucion del programa

### Opción A: Usando Visual Studio Code (Recomendado)
1.  Abra la carpeta del proyecto en VS Code.
2.  Espere a que se cargue la configuración de Java (carpeta `.vscode`).
3.  Abra el archivo `src/GenderPredictor.java`.
4.  Presione `F5` o haga clic en **"Run"** arriba de la función `main`.

### Opción B: Desde la Terminal (Línea de comandos nativa del sistema operativo)
Si prefiere ejecutar manualmente, siga estos pasos estrictos:

**1. Ubicación:**
Abra el Símbolo del sistema (CMD) y navegue a la carpeta raíz del proyecto (donde se ven las carpetas `src` y `lib`) que suele ser la carpeta llamada GitHub.
> Ejemplo: `cd C:\Usuarios\TuUsuario\Documentos\GenderizeApp`

**2. Compilación:**
Ejecute el siguiente comando para compilar el código junto con la librería:
```cmd
javac -cp "lib/*" src/GenderPredictor.java
```

**3. Ejecución: Una vez compilado, inicie el programa con este comando:**

`java -cp "lib/*;src" GenderPredictor`

(nota: Es importante respetar las comillas y el punto y coma en el comando).

**Ejemplo de uso**

 En ambos casos el programa solicitará un nombre en la consola:

Ingresa un nombre (ej. Andrea, Kevin): Andrea.

y la salida esperada sera:

```Terminal
--- PREDICTOR DE GÉNERO (Probabilístico) ---
Resultados para: ANDREA
------------------------------------------------
 Género Predicho: Femenino
 Certeza: 99%
 Tamaño de la muestra: 14230 personas
------------------------------------------------
```
## Solución de Problemas Comunes

Si experimenta inconvenientes al ejecutar el programa, consulte los siguientes casos:

### 1. Error: `java.lang.NoClassDefFoundError: com/google/gson/...`
* **Síntoma:** El programa compila, pero al ejecutarse se cierra inmediatamente mostrando un error relacionado con `Gson`.
* **Causa:** Java no encuentra la librería externa porque el comando de ejecución no incluyó el *ClassPath* correcto.
* **Solución:** Asegúrese de incluir el parámetro `-cp "lib/*;src"` en el comando de ejecución.
    * *Incorrecto:* `java GenderPredictor`
    * *Correcto:* `java -cp "lib/*;src" GenderPredictor`

### 2. Error: `java.net.UnknownHostException`
* **Síntoma:** El programa muestra un error de conexión o "fallo al conectar con la API".
* **Causa:** No hay conexión a internet disponible.
* **Solución:** Verifique su conexión WiFi/Ethernet. Este programa requiere acceso a internet para consultar los servidores de *Genderize.io*.

### 3. El programa no compila (`Cannot find symbol: HttpClient`)
* **Síntoma:** Errores al compilar indicando que no reconoce `HttpClient` o `HttpRequest`.
* **Causa:** Está utilizando una versión antigua de Java (JDK 8 o inferior).
* **Solución:** Este proyecto requiere **Java 11 en consola o java 17 en vs code** minimo, ya que utiliza el cliente HTTP moderno introducido en esa versión. Actualice su JDK.

### 4. Respuesta: "No pudimos determinar el género"
* **Síntoma:** Ingresa un nombre y el programa dice que no tiene resultados.
* **Causa:** El nombre ingresado es muy inusual, está mal escrito o contiene caracteres numéricos que la API no reconoce.
* **Solución:** Intente con un nombre real común (ej. "Carlos", "Maria") sin espacios ni números.

### 5. Error 429: "Too Many Requests"
* **Síntoma:** El programa muestra un código de error 429.
* **Causa:** La API pública de Genderize tiene un límite de 1000 consultas por día.
* **Solución:** Espere un momento antes de volver a intentar o pruebe desde otra dirección IP.

### Problemas Específicos de Visual Studio Code

Si está utilizando VS Code y experimenta problemas de configuración, intente lo siguiente:

**1. Error: "Java runtime could not be started" o no se reconoce el JDK**
* **Síntoma:** VS Code muestra una alerta indicando que no encuentra un JDK válido o el botón "Run" no aparece.
* **Causa:** VS Code está intentando usar una versión antigua de Java (ej. 1.8) o no encuentra la ruta de instalación.
* **Solución:**
    1. Presione `Ctrl + Shift + P` para abrir la paleta de comandos.
    2. Escriba y seleccione: `Java: Configure Java Runtime`.
    3. En la pestaña "Installed JDKs", asegúrese de seleccionar la versión 11, 17 o 21 (según la que tenga instalada). Si no aparece, use el botón de "Add" para buscar la carpeta de instalación.

**2. Error: Líneas rojas en las importaciones (Falsos Positivos)**
* **Síntoma:** El código marca errores en `import com.google.gson...` aunque la librería esté en la carpeta `lib`.
* **Causa:** El servidor de lenguaje de Java en VS Code necesita actualizar su caché.
* **Solución:**
    1. Presione `Ctrl + Shift + P`.
    2. Escriba y seleccione: `Java: Clean Java Language Server Workspace`.
    3. Confirme con "Restart and Delete". Esto forzará a VS Code a reconocer las librerías nuevamente.
