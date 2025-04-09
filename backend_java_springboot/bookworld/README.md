# 📚 BookWorld (fragmento de backend - Java Spring Boot)

Este repositorio muestra parte del backend de **BookWorld** (nombre provisional), una aplicación web de valoración de libros con funcionalidades sociales. La finalidad de este código es **mostrar cómo trabajo con Java, Spring Boot, JPA y el diseño de APIs REST limpias y bien estructuradas.**

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- Lombok
- ModelMapper
- MySQL
- Maven

---

## 📦 ¿Qué contiene este repositorio?

Este fragmento de código incluye:

- Un modelo de entidad JPA para libros (`Libro`)
- Un endpoint de búsqueda de libros con JPA
- Configuración CORS personalizada (parte de ella)
- Un sistema global de manejo de errores con `@RestControllerAdvice` y clases personalizadas (`ApiError`, `GlobalControllerAdvice`)

---

## 🧠 ¿Por qué este fragmento?

La intención es **mostrar parte del backend real de una aplicación más grande** sin comprometer la seguridad ni mostrar lógica sensible.

---

## 🔐 ¿Qué no incluye y por qué?

Por motivos de seguridad, **no se incluye la parte completa de usuarios ni la configuración de autenticación con Spring Security** (gestión de contraseñas, tokens JWT, etc.).

Sin embargo, la aplicación completa implementa:

- Registro y login con validación de credenciales
- Cifrado de contraseñas con BCrypt
- Autenticación basada en JWT
- Control de acceso por roles

---

## 🧪 Ejemplo de respuesta ante error

Gracias al sistema global de manejo de errores, el backend devuelve respuestas claras como:

```json
{
  "status": "BAD_REQUEST",
  "date": "09/04/2025 15:34:02",
  "message": "Los parámetros de búsqueda son inválidos"
}
