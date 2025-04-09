# BookWorld

**BookWorld** es una aplicación web que combina funcionalidades de red social y plataforma de valoración de libros. Los usuarios pueden valorar libros, crear listas de lectura personalizadas, explorar publicaciones de otros usuarios y disfrutar de una experiencia interactiva en la comunidad lectora. Esta aplicación está desarrollada utilizando **Spring Boot** en el backend y **Angular** en el frontend, con MySQL como base de datos.

## Licencia

Este proyecto está **bajo todos los derechos reservados**. No se permite el uso, modificación, distribución ni reproducción del código ni de la aplicación sin el permiso explícito del propietario.


## Características Principales

- **Autenticación y Registro de Usuarios**: Los usuarios pueden crear cuentas, iniciar sesión y gestionar su perfil personal.
- **Valoración de Libros**: Los usuarios pueden calificar libros y compartir sus opiniones.
- **Listas de Lectura**: Los usuarios pueden crear listas personalizadas de libros, como "Favoritos", "Must Read", etc.
- **Exploración de Libros**: Los usuarios pueden explorar una amplia variedad de libros, ver detalles, y valorar libros.
- **Interacción Social**: Los usuarios pueden ver publicaciones de otros, compartir comentarios y participar en la comunidad de lectores.

## Tecnologías Utilizadas

- **Backend**:  
  - **Spring Boot** (Java)  
  - **Spring Security** para autenticación y autorización  
  - **JPA / Hibernate** para el manejo de la base de datos  
  - **JWT** para autenticación basada en tokens  
  - **MySQL** como base de datos

- **Frontend**:  
  - **Angular**  
  - **Angular Material** para componentes de interfaz de usuario  
  - **Nx Workspace** para gestionar múltiples aplicaciones y bibliotecas

- **Desarrollo y Despliegue**:  
  - **Docker** para contenerización del proyecto  
  - **Spring Boot DevTools** para una experiencia de desarrollo optimizada  
  - **ModelMapper** para mapear entidades del backend a DTOs (Data Transfer Objects)

## Estructura del Proyecto

### Backend (Spring Boot)

- `src/main/java/com/bookworld`  
  - **config**: Archivos de configuración de la aplicación (CORS, seguridad, etc.)  
  - **controller**: Controladores que manejan las peticiones HTTP  
  - **model**: Entidades JPA para interactuar con la base de datos  
  - **repository**: Repositorios de Spring Data JPA para acceder a la base de datos  
  - **service**: Servicios que contienen la lógica de negocio  
  - **errorconfig**: Manejo global de errores y excepciones

- `src/main/resources`  
  - **application.properties**: Configuración de la aplicación, incluyendo la base de datos

### Frontend (Angular)

- `src/app`  
  - **components**: Componentes principales de la aplicación (Home, Login, Register, etc.)  
  - **services**: Servicios para interactuar con el backend (autenticación, libros, usuarios, etc.)  
  - **models**: Clases de modelos y DTOs para la transferencia de datos  
  - **guards**: Guards para proteger las rutas privadas  
  - **store**: Estado de la aplicación (si utilizas NgRx o algo similar)

## Licencia

Este proyecto está bajo la **Licencia MIT**.
