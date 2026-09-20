package biblioteca.modelo;

import biblioteca.enums.EstadoDisponibilidad;

public abstract class Libro {

    private int idLibro;
    private String titulo;
    private int anioPublicacion;
    private EstadoDisponibilidad estado;
    private Autor autor;

    public Libro(int idLibro, String titulo, int anioPublicacion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.estado = EstadoDisponibilidad.DISPONIBLE;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public EstadoDisponibilidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoDisponibilidad estado) {
        this.estado = estado;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean estaDisponible() {
        return estado == EstadoDisponibilidad.DISPONIBLE;
    }

    public void marcarComoPrestado() {
        estado = EstadoDisponibilidad.PRESTADO;
    }

    public void marcarComoDisponible() {
        estado = EstadoDisponibilidad.DISPONIBLE;
    }

    public String obtenerInformacion() {
        return "ID: " + idLibro +
                ", título: " + titulo +
                ", año: " + anioPublicacion +
                ", estado: " + estado;
    }

    // Sobrecarga
    public String obtenerInformacion(boolean incluirAutor) {
        String informacion = obtenerInformacion();

        if (incluirAutor && autor != null) {
            informacion += ", autor: " + autor.getNombre();
        }

        return informacion;
    }
}