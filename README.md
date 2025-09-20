
# ForoHub - API RESTful para Gestión de Tópicos

---
Este proyecto fue desarrollado para el Challenge ForoHub del programa Oracle Next Education (ONE), en el marco de la formación en Java y Spring Framework de la especialización Backend. Se trata de una API RESTful para la gestión de tópicos en un foro, con seguridad implementada mediante JWT y validación de credenciales encriptadas con BCrypt, además de documentación interactiva a través de Swagger.
---

## 🛠️ Tecnologías Utilizadas

```
- Lenguaje: Java 17
- Framework: Spring Boot 3.5.3
- Seguridad: Spring Security 6 + JWT + BCrypt
- Persistencia: Spring Data JPA
- Base de Datos: MySQL
- Migraciones de esquema: Flyway
- Validación: Jakarta Bean Validation
- Documentación API: SpringDoc OpenAPI + Swagger UI
- Control de dependencias: Maven
- IDE: IntelliJ IDEA / Eclipse
```

---

## ⚙️ Configuración Inicial

### 1. Clonar el repositorio

### 2. Configurar el archivo `application.properties` con tu BD MySQL

## 🧾 Inserción previa en la base de datos

Antes de hacer login, es necesario insertar manualmente un usuario en la base de datos con la contraseña encriptada en BCrypt:
Puedes usar herramientas como [BCrypt Generator](https://bcrypt-generator.com/) para generar el hash de una contraseña como `123456`.

---

### Request body - ejemplo

```json
{
  "email": "usuario@email.com",
  "contrasenia": "123456"
}
```

### Response

```json
{
  "ok": true,
  "message": "Token generado correctamente",
  "data": {
    "jwt": "eyJhbGciOiJIUzI1NiIsInR..."
  }
}
```

Este token debe usarse en las siguientes peticiones agregándolo al `Authorization` header como:

```
Bearer eyJhbGciOiJIUzI1NiIsInR...
```

---

## 📄 Documentación Swagger

Disponible automáticamente una vez ejecutada la aplicación:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## ✨ Créditos

Proyecto realizado por Raúl Ichiro Rosas Chinen como parte del programa Oracle Next Education (ONE) - Alura Latam.