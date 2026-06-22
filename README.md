# Notification API - Prueba Técnica

## Descripción

Proyecto desarrollado como prueba técnica para el cargo de Software Engineer Entry Level.

El proyecto contiene:

* Parte 1: ejercicio de lógica de programación.
* Parte 2: API REST para envío de notificaciones.
* Parte 3: casos de prueba, pruebas automatizadas y análisis QA.

---

## Tecnologías Utilizadas

* Java 21
* Spring Boot
* Maven
* Lombok
* JUnit 5
* MockMvc

---

## Parte 1 - Lógica de Programación

### Descripción

Se desarrolló una solución que recibe una lista de números enteros y genera una nueva lista que:

* Elimina los valores duplicados.
* Ordena los elementos de menor a mayor.
* No utiliza funciones nativas de ordenamiento.
* No utiliza estructuras nativas para eliminar duplicados.

### Solución

La implementación utiliza únicamente:

* Ciclos `for`
* Condicionales `if`
* Listas `ArrayList`
* Métodos propios

Primero se recorre la lista original para construir una nueva lista sin elementos duplicados. Luego se aplica un algoritmo de ordenamiento manual, usando Selection Sort, para ordenar los elementos de menor a mayor.

### Ejemplo

Entrada:

```text
[4, 2, 7, 2, 4, 9, 1]
```

Salida:

```text
[1, 2, 4, 7, 9]
```

### Ubicación

```text
src/main/java/com/acgp/part1Logic/LogicExercise.java
```

---

## Parte 2 - API de Notificaciones

### Descripción

API desarrollada con Spring Boot para el envío de notificaciones mediante distintos canales.

Canales soportados:

* EMAIL
* SMS

Las notificaciones se almacenan en memoria y pueden ser consultadas posteriormente mediante la API.

---

## Patrón de Diseño Utilizado

### Strategy Pattern

Se implementó el patrón Strategy para seleccionar dinámicamente el proveedor de notificaciones según el canal recibido en la solicitud.

Proveedores implementados:

* EmailNotificationProvider
* SmsNotificationProvider

Este diseño permite agregar nuevos canales de comunicación sin modificar la lógica principal del servicio.

---

## Endpoints

### Crear Notificación

**POST** `/api/notifications`

Request:

```json
{
  "userId": "123",
  "message": "Hola",
  "channelType": "EMAIL"
}
```

Response:

```json
{
  "status": "SUCCESS",
  "message": "Notificación creada correctamente",
  "data": {
    "userId": "123",
    "message": "Hola",
    "channelType": "EMAIL"
  }
}
```

---

### Obtener Historial de Notificaciones

**GET** `/api/notifications`

Response:

```json
{
  "status": "SUCCESS",
  "message": "Notificaciones obtenidas correctamente",
  "data": []
}
```

---

## Parte 3 - QA y Automatización

### Casos de Prueba

| ID    | Caso de Prueba                        | Resultado Esperado                |
| ----- | ------------------------------------- | --------------------------------- |
| TC-01 | Crear notificación por EMAIL          | Notificación creada correctamente |
| TC-02 | Crear notificación por SMS            | Notificación creada correctamente |
| TC-03 | Crear notificación sin mensaje        | HTTP 400 Bad Request              |
| TC-04 | Crear notificación con canal inválido | HTTP 400 Bad Request              |
| TC-05 | Obtener historial de notificaciones   | HTTP 200 OK                       |

---

### Pruebas Automatizadas

Se implementaron pruebas automatizadas utilizando JUnit 5 y MockMvc.

Pruebas implementadas:

* createEmailNotification
* createSmsNotification
* validateRequiredMessage
* validateInvalidChannel
* getAllNotifications

---

## Análisis QA

### 1. ¿Qué automatizarías primero y por qué?

Automatizaría primero las pruebas del endpoint `POST /api/notifications`, ya que corresponde a la funcionalidad principal del sistema y es el punto de entrada de todas las notificaciones.

Las pruebas automatizadas verificarían escenarios como la creación de notificaciones por EMAIL y SMS, así como la validación de datos obligatorios y canales no soportados. Esto permite detectar rápidamente errores cuando se realizan cambios en el código y asegurar que la funcionalidad principal continúe operando correctamente.

Posteriormente automatizaría las pruebas del endpoint `GET /api/notifications`, para verificar la correcta recuperación del historial de notificaciones almacenadas.

### 2. ¿Qué riesgos identificas en esta API?

* Recepción de datos inválidos o incompletos.
* Uso de canales de notificación no soportados.
* Pérdida de información al reiniciar la aplicación, debido al almacenamiento en memoria.
* Crecimiento indefinido del historial de notificaciones almacenado.
* Ausencia de mecanismos de autenticación y autorización para proteger los endpoints.

---

## Ejecución del Proyecto

### Levantar la aplicación

Linux o Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

La aplicación quedará disponible en:

```text
http://localhost:8080
```

---

## Ejecutar Pruebas

Linux o Mac:

```bash
./mvnw test
```

Windows:

```bash
mvnw.cmd test
```
