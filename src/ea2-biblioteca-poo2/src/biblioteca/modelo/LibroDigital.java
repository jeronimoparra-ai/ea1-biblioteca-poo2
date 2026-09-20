package biblioteca.modelo;

public class LibroDigital extends Libro {

    private String isbnDigital;
    private String formato;
    private double tamanoArchivoMB;
    private String urlDescarga;

    public LibroDigital(
            int idLibro,
            String titulo,
            int anioPublicacion,
            String isbnDigital,
            String formato,
            double tamanoArchivoMB,
            String urlDescarga) {

        super(idLibro, titulo, anioPublicacion);

        this.isbnDigital = isbnDigital;
        this.formato = formato;
        this.tamanoArchivoMB = tamanoArchivoMB;
        this.urlDescarga = urlDescarga;
    }

    public String getIsbnDigital() {
        return isbnDigital;
    }

    public void setIsbnDigital(String isbnDigital) {
        this.isbnDigital = isbnDigital;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamanoArchivoMB() {
        return tamanoArchivoMB;
    }

    public void setTamanoArchivoMB(double tamanoArchivoMB) {
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    public String obtenerEnlaceDescarga() {
        return urlDescarga;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion()
                + ", ISBN digital: " + isbnDigital
                + ", formato: " + formato
                + ", tamaño: " + tamanoArchivoMB + " MB";
    }
}