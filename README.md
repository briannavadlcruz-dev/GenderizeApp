# Tarea extra consumo de una API: Predictor de Género (Java + API Genderize)

Este proyecto es una aplicación de consola desarrollada para la clase de Estructura de Datos. Consume la API pública de [Genderize.io](https://genderize.io/) para determinar el género de una persona basándose en la probabilidad estadística de su nombre.

## Requisitos tecnologicos 
* **Lenguaje:** Java (JDK 11 o superior)
* **Librería:** Google Gson 2.13.2 (Incluida en la carpeta `lib`)
* **API:** RESTful HTTP Request

## Estructura del Proyecto
* `src/`: Contiene el código fuente (`GenderPredictor.java`).
* `lib/`: Contiene la librería necesaria (`gson-2.10.1.jar`).

## Instrucciones de ejecucion del programa

### Opción A: Usando Visual Studio Code (Recomendado)
1.  Abrir la carpeta del proyecto en VS Code.
2.  Asegurarse de que el archivo `.jar` en la carpeta `lib` esté agregado en "Referenced Libraries" o en la carpeta lib.
3.  Abrir `src/GenderPredictor.java`.
4.  Presionar `F5` o hacer clic en "Run".

### Opción B: Desde la Terminal (Línea de comandos)
Si prefiere compilar manualmente, ubíquese en la raíz del proyecto y ejecute:

**1. Compilar:**
```bash
javac -cp "lib/*;src" src/GenderPredictor.java
Nota: En Mac/Linux use dos puntos : en lugar de punto y coma ; en el classpath
