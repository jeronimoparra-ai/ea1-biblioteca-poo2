package biblioteca.modelo;

import biblioteca.enums.EstadoPrestamo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private int idPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaDevolucionReal;
    private EstadoPrestamo estado;

    // Composición: el préstamo tiene un libro
    private final Libro libro;

    public Prestamo(int idPrestamo, Libro libro, LocalDate fechaPrestamo) {

        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (!libro.estaDisponible()) {
            throw new IllegalStateException(
                    "El libro no está disponible para préstamo."
            );
        }

        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(15);
        this.fechaDevolucionReal = null;
        this.estado = EstadoPrestamo.ACTIVO;

        // El libro cambia de estado cuando se crea el préstamo
        libro.marcarComoPrestado();
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void registrarDevolucion(LocalDate fecha) {

        if (estaDevuelto()) {
            throw new IllegalStateException(
                    "El préstamo ya fue devuelto."
            );
        }

        this.fechaDevolucionReal = fecha;
        this.estado = EstadoPrestamo.DEVUELTO;

        libro.marcarComoDisponible();
    }

    public boolean estaDevuelto() {
        return estado == EstadoPrestamo.DEVUELTO;
    }

    public int diasPrestamo() {

        LocalDate fechaFinal;

        if (fechaDevolucionReal != null) {
            fechaFinal = fechaDevolucionReal;
        } else {
            fechaFinal = LocalDate.now();
        }

        return (int) ChronoUnit.DAYS.between(
                fechaPrestamo,
                fechaFinal
        );
    }

    public String obtenerInformacion() {
        return "Préstamo #" + idPrestamo
                + " | Libro: " + libro.getTitulo()
                + " | Fecha préstamo: " + fechaPrestamo
                + " | Fecha devolución: " + fechaDevolucion
                + " | Estado: " + estado;
    }
}