package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Autor {

    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;

    private List<Libro> libros;

    public Autor(
            int idAutor,
            String nombre,
            String nacionalidad,
            String fechaNacimiento) {

        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = new ArrayList<>();
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void agregarLibro(Libro libro) {
        if (libro != null && !libros.contains(libro)) {
            libros.add(libro);
            libro.setAutor(this);
        }
    }

    public String obtenerInformacion() {
        return "ID: " + idAutor
                + ", nombre: " + nombre
                + ", nacionalidad: " + nacionalidad
                + ", fecha de nacimiento: " + fechaNacimiento;
    }
}