package biblioteca.modelo;

public class LibroFisico extends Libro {

    private String isbn;
    private int numeroCopias;
    private String ubicacion;

    public LibroFisico(
            int idLibro,
            String titulo,
            int anioPublicacion,
            String isbn,
            int numeroCopias,
            String ubicacion) {

        super(idLibro, titulo, anioPublicacion);

        this.isbn = isbn;
        this.numeroCopias = numeroCopias;
        this.ubicacion = ubicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String obtenerUbicacion() {
        return ubicacion;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion()
                + ", ISBN: " + isbn
                + ", copias: " + numeroCopias
                + ", ubicación: " + ubicacion;
    }
}