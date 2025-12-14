# MundialScore 🏆⚽

MundialScore es una aplicación web desarrollada con Spring Boot para gestionar pronósticos de resultados de partidos de fútbol (conocido como prode, quiniela o porra). Los usuarios pueden registrarse, realizar predicciones sobre los marcadores de los partidos y competir en una tabla de clasificación basada en sus aciertos.

## 🚀 Características

- **Gestión de Usuarios**: Registro e inicio de sesión seguro.
- **Panel de Control (Dashboard)**: Visualización de los próximos partidos disponibles.
- **Pronósticos**: Los usuarios pueden ingresar sus predicciones de marcador para cada partido.
- **Tabla de Posiciones**: Ranking de usuarios basado en los puntos obtenidos por sus aciertos.
- **Panel de Administración**: Gestión de partidos (crear, editar, borrar) y actualización de resultados reales.

## 🛠️ Tecnologías Utilizadas

- **Java**: 17
- **Framework**: Spring Boot
- **Base de Datos**: MySQL / PostgreSQL
- **Persistencia**: Spring Data JPA
- **Seguridad**: Spring Security
- **Frontend**: HTML5, CSS3, JavaScript (Thymeleaf para renderizado del lado del servidor)
- **Documentación API**: OpenAPI (Swagger)
- **Herramientas**: Maven, Lombok

## 📋 Requisitos Previos

Asegúrate de tener instalado lo siguiente:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- Una base de datos MySQL o PostgreSQL corriendo localmente.

## ⚙️ Configuración e Instalación

1.  **Clonar el repositorio**
    ```bash
    git clone https://github.com/tu-usuario/mundialscore.git
    cd mundialscore
    ```

2.  **Configurar la Base de Datos**
    Asegúrate de actualizar el archivo `src/main/resources/application.properties` con las credenciales de tu base de datos:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/mundialscore_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

3.  **Compilar y Ejecutar**
    ```bash
    mvn spring-boot:run
    ```

    La aplicación estará disponible en `http://localhost:8080`.

## 📖 Documentación de la API

MundialScore incluye documentación interactiva de la API generada con OpenAPI. Una vez que la aplicación esté corriendo, puedes acceder a ella en:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`

## 🤝 Acceder como administrador
Para poder acceder como administrador es usuario: admin y contraseña: admin123.

