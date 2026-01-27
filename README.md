# 🐾 Gestión Protectora

Aplicación de consola desarrollada en **Java** para la gestión de una protectora de animales.  
Permite administrar animales, adoptantes y adopciones utilizando **MySQL** como sistema de persistencia mediante **JDBC**.

---

## 📌 Características

- Gestión completa de animales
- Gestión de adoptantes
- Registro y listado de adopciones
- Persistencia de datos en base de datos MySQL
- Arquitectura basada en DAO
- Programación orientada a objetos

---

## 🛠️ Tecnologías utilizadas

- Java (JDK 23)
- MySQL
- JDBC
- IntelliJ IDEA
- SQL

---

## 📂 Estructura del proyecto

- com.gestionprotectora
│
├── model        → Clases de dominio (Animal, Adoptante, Adopcion)
├── dao          → Acceso a datos (CRUD con JDBC)
├── DBConnection → Gestión de la conexión a la base de datos
└── Main         → Menú principal y flujo de la aplicación

---

## ⚙️ Funcionalidades

### 🐶 Gestión de animales
- Añadir animales
- Listar animales
- Listar animales disponibles
- Marcar animales como adoptados
- Eliminar animales

### 👤 Gestión de adoptantes
- Añadir adoptantes
- Listar adoptantes

### ❤️ Gestión de adopciones
- Registrar adopciones
- Listar adopciones utilizando JOIN entre tablas

---

## 🗄️ Base de datos

La aplicación utiliza una base de datos **MySQL** con las siguientes tablas:

- `animal`
- `adoptante`
- `adopcion`

Las relaciones entre entidades se gestionan mediante claves foráneas.

---

## ▶️ Ejecución del proyecto

1. Crear la base de datos en MySQL
2. Configurar los datos de conexión en la clase `DBConnection`
3. Ejecutar la clase `Main`
4. Usar el menú de consola para interactuar con la aplicación

---

## 🧠 Conceptos aplicados

- Patrón DAO
- JDBC y `PreparedStatement`
- Relaciones entre tablas (JOIN)
- Manejo de excepciones
- Separación entre lógica y acceso a datos

---

## 🚀 Mejoras futuras

- Interfaz gráfica con JavaFX
- Migración a Spring Boot
- Creación de una API REST
- Frontend web
- Validaciones y seguridad

---

## 👨‍💻 Autor

Sergio Gutiérrez  
Proyecto desarrollado como parte de la formación en **Desarrollo de Aplicaciones Multiplataforma (DAM)**.
Este proyecto se ha desarrollado de forma incremental, priorizando la comprensión del código y la separación de responsabilidades, con vistas a una futura migración a Spring Boot.
