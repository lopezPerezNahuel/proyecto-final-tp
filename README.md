# El Archivo del Infinito

# Desarrollador

Nahuel López Pérez




"El Archivo del Infinito" es un videojuego de género roguelike en dos dimensiones con perspectiva cenital (top-down). El jugador asume el rol de un bibliotecario nocturno que descubre que, durante su jornada, una de las estanterías del establecimiento funciona como puerta de acceso a un entorno hostil y misterioso. La experiencia se estructura en torno a un ciclo de riesgo y recompensa: el jugador debe explorar, recuperar libros perdidos y combatir anomalías bajo la presión de un límite de tiempo, el amanecer, donde debe volver a su puesto de trabajo antes de que su jefe lo encuentre fuera de este. El progreso permanente del jugador libros recuperados, mejoras desbloqueadas y estadísticas se conserva entre incursiones mediante una base de datos local.

## Tecnologías principales

- Versión de java: 17
- Framework LibGDX 1.14.2
- Herramienta de configuración: gdx-liftoff 1.14.2.1
- Plataforma de desarrollo de objetivo: Escritorio mediante LWJGL3
- SQLite: Tecnología planificada
  
## **Enlace a la Wiki del Proyecto Propuesta Detallada:**
### Ver la propuesta completa del proyecto [Aquí](https://github.com/lopezPerezNahuel/proyecto-final-tp/wiki)

# Requisitos Previos

Para compilar y ejecutar este proyecto, asegúrese de tener instalado lo siguiente en su sistema:

- JDK (Java Development Kit): Debe instalado el JDK 17 o una versión superior compatible
- GIT: Para poder clonar el repositorio



# Cómo Compilar y Ejecutar el proyecto

## Pasos:



## 1. Clonar el repositorio:

``` bash
git clone https://github.com/lopezPerezNahuel/proyecto-final-tp
cd proyecto-final-tp
```


## 2. Compilar el proyecto con el wrapper de Gradle incluido en LibGDX:

### Windows:
``` bash
gradlew.bat build
```

### Linux / macOS:
``` bash
./gradlew build
```


## 3. Ejecutar el juego en escritorio:

### Windows:
``` bash
gradlew.bat lwjgl3:run
```

### Linux / macOS:
``` bash
./gradlew lwjgl3:run
```
