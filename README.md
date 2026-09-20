<div align="center">

# 📚 Sistema de Biblioteca — POO II

### Del diagrama de clases UML a su implementación funcional en Java

![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![UML](https://img.shields.io/badge/UML-Diagrama%20de%20Clases-blue?logo=uml&logoColor=white)
![Status](https://img.shields.io/badge/Estado-En%20desarrollo-yellow)
![License](https://img.shields.io/badge/Uso-Académico-lightgrey)

*Programación Orientada a Objetos II — IU Digital de Antioquia — Grupo 13*

</div>

---

## 🎯 Sobre el proyecto

Este repositorio reúne el trabajo colaborativo del **Grupo 13** a lo largo de dos evidencias de aprendizaje del curso:

| Evidencia | Qué se hizo |
|---|---|
| **EA1** — Diagrama de clases UML | Modelado de un sistema de gestión bibliotecaria aplicando abstracción, encapsulamiento, herencia, polimorfismo y principios SOLID. |
| **EA2/EA3** — Implementación en Java | Traducción fiel de ese diagrama a código Java funcional, con clase de prueba, control de versiones colaborativo y sustentación en video. |

La idea central del proyecto es demostrar que un buen diseño UML se traduce, casi sin fricción, en una implementación de software ordenada, extensible y fácil de mantener.

---

## 👥 Integrantes — Grupo 13

| Nombre |
|---|
| Imanol Mejía Lotero |
| Luis Fernando Castaño |
| Andrés Jerónimo Parra Bastidas |
| Juan Andrés Cadavid Correa |

---

## 🗂️ Estructura del repositorio

```
📦 ea1-biblioteca-poo2
├── 📁 diagrama/              # Diagrama de clases UML (EA1)
├── 📁 informe/               # Informes PDF (EA1 y EA2) con portada, objetivos y conclusiones
├── 📁 src/                   # Código fuente Java (EA2)
│   └── com/biblioteca/
│       ├── Main.java             → Clase de prueba: demuestra el sistema en ejecución
│       └── modelo/
│           ├── Autor.java
│           ├── Libro.java            (abstracta)
│           ├── LibroFisico.java      (extends Libro)
│           ├── LibroDigital.java     (extends Libro)
│           ├── EstadoDisponibilidad.java
│           ├── Prestamo.java
│           ├── EstadoPrestamo.java
│           └── Usuario.java
├── 📁 docs/                  # Evidencia de compilación y ejecución
└── README.md
```

---

## 🧩 Del diagrama al código

| Elemento del diagrama | Relación | Implementación en Java |
|---|---|---|
| Autor → Libro | Agregación (0..*) | `List<Libro>` dentro de `Autor` |
| Libro → LibroFisico / LibroDigital | Herencia | `extends Libro` |
| Libro → Préstamo | Composición | `Prestamo` referencia un `Libro` y sus fechas |
| Usuario → Préstamo | Asociación ("realiza") | `Prestamo` referencia un `Usuario` |

**Pilares de POO aplicados:** encapsulamiento (atributos `private` + getters/setters), herencia, polimorfismo (`obtenerInformacion()` sobrescrito), sobrecarga (`registrarDevolucion()` con y sin parámetros).

**Principios SOLID identificados:**

| Principio | Dónde |
|---|---|
| 🔹 SRP | `Autor`, `Usuario` |
| 🔹 OCP | `Libro` (abstracta) |
| 🔹 LSP | `LibroFisico` / `LibroDigital` |
| 🔹 DIP | `Prestamo` (depende del tipo abstracto `Libro`) |

---

## 🚀 Cómo ejecutar el proyecto

```bash
# Compilar
javac -d bin $(find src -name "*.java")

# Ejecutar
java -cp bin com.biblioteca.Main
```

---

## 🔗 Enlaces del proyecto

| Recurso | Enlace |
|---|---|
| 🖼️ Diagrama de clases (draw.io) | [Ver diagrama](https://drive.google.com/file/d/1aIydJO9S9WCgRq2z0ysX-u7Yax-LGk8b/view?usp=sharing) |
| 🎥 Video sustentación EA1 | `[pendiente]` |
| 🎥 Video sustentación EA2 (5-8 min) | `[pendiente]` |

---

## 📝 Control de versiones

Cada integrante aporta mediante commits propios e identificables, con mensajes descriptivos (ej. `"Implementa clase Autor con agregacion hacia Libro"`), evidenciando la participación equitativa del equipo a lo largo de ambas evidencias.

<div align="center">

*IU Digital de Antioquia — 2026*

</div>
