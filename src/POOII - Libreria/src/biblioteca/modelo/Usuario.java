package biblioteca.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDate fechaRegistro;

    private List<Prestamo> prestamos;

    public Usuario(
            int idUsuario,
            String nombre,
            String email,
            String telefono,
            LocalDate fechaRegistro) {

        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.prestamos = new ArrayList<>();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public boolean puedePedirPrestamo() {

        int prestamosActivos = 0;

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.estaDevuelto()) {
                prestamosActivos++;
            }
        }

        return prestamosActivos < 3;
    }

    public void agregarPrestamo(Prestamo prestamo) {

        if (prestamo == null) {
            throw new IllegalArgumentException(
                    "El préstamo no puede ser nulo."
            );
        }

        if (!puedePedirPrestamo()) {
            throw new IllegalStateException(
                    "El usuario tiene el máximo de préstamos activos."
            );
        }

        prestamos.add(prestamo);
    }

    public String obtenerInformacion() {
        return "Usuario #" + idUsuario
                + " | Nombre: " + nombre
                + " | Email: " + email
                + " | Teléfono: " + telefono
                + " | Fecha registro: " + fechaRegistro;
    }
}