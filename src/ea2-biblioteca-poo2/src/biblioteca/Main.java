package biblioteca;

import biblioteca.enums.EstadoDisponibilidad;
import biblioteca.modelo.Autor;
import biblioteca.modelo.Libro;
import biblioteca.modelo.LibroDigital;
import biblioteca.modelo.LibroFisico;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Usuario;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE BIBLIOTECA ===");

        // =====================================================
        // 1. CREAR AUTORES
        // =====================================================
        Autor autor1 = new Autor(
                1,
                "Gabriel García Márquez",
                "Colombiana",
                "06/03/1927"
        );

        Autor autor2 = new Autor(
                2,
                "George Orwell",
                "Británica",
                "25/06/1903"
        );

        // =====================================================
        // 2. CREAR LIBROS FÍSICOS Y DIGITALES
        // =====================================================
        LibroFisico libroFisico = new LibroFisico(
                101,
                "Cien años de soledad",
                1967,
                "978-0307474728",
                5,
                "Estantería A-12"
        );

        LibroDigital libroDigital = new LibroDigital(
                102,
                "1984",
                1949,
                "978-0451524935",
                "PDF",
                3.5,
                "https://biblioteca.com/libros/1984"
        );

        // =====================================================
        // 3. RELACIONAR AUTORES CON SUS LIBROS
        // =====================================================
        autor1.agregarLibro(libroFisico);
        autor2.agregarLibro(libroDigital);

        // =====================================================
        // 4. MOSTRAR INFORMACIÓN DE AUTORES
        // =====================================================
        System.out.println("\n--- AUTORES ---");
        System.out.println(autor1.obtenerInformacion());
        System.out.println(autor2.obtenerInformacion());

        // =====================================================
        // 5. MOSTRAR INFORMACIÓN DE LIBROS
        //    Se usa polimorfismo al guardar los libros como Libro.
        // =====================================================
        Libro libro1 = libroFisico;
        Libro libro2 = libroDigital;

        System.out.println("\n--- LIBROS ---");
        System.out.println(libro1.obtenerInformacion(true));
        System.out.println(libro2.obtenerInformacion(true));

        System.out.println("Ubicación libro físico: " + libroFisico.obtenerUbicacion());
        System.out.println("Enlace libro digital: " + libroDigital.obtenerEnlaceDescarga());

        // =====================================================
        // 6. CREAR USUARIOS
        // =====================================================
        Usuario usuario1 = new Usuario(
                1,
                "Juan Pérez",
                "juan@email.com",
                "3001234567",
                LocalDate.now()
        );

        Usuario usuario2 = new Usuario(
                2,
                "Ana Gómez",
                "ana@email.com",
                "3019876543",
                LocalDate.now()
        );

        System.out.println("\n--- USUARIOS ---");
        System.out.println(usuario1.obtenerInformacion());
        System.out.println(usuario2.obtenerInformacion());

        // =====================================================
        // 7. CREAR UN PRÉSTAMO
        // =====================================================
        Prestamo prestamo1 = new Prestamo(
                1001,
                libroFisico,
                LocalDate.now()
        );

        usuario1.agregarPrestamo(prestamo1);

        System.out.println("\n--- PRÉSTAMO ---");
        System.out.println(prestamo1.obtenerInformacion());
        System.out.println("Días de préstamo: " + prestamo1.diasPrestamo());
        System.out.println("¿Usuario puede pedir otro préstamo? " + usuario1.puedePedirPrestamo());
        System.out.println("Estado del libro: " + libroFisico.getEstado());

        // =====================================================
        // 8. REGISTRAR DEVOLUCIÓN
        // =====================================================
        prestamo1.registrarDevolucion(LocalDate.now());

        System.out.println("\n--- DESPUÉS DE LA DEVOLUCIÓN ---");
        System.out.println(prestamo1.obtenerInformacion());
        System.out.println("Días de préstamo: " + prestamo1.diasPrestamo());
        System.out.println("¿Préstamo devuelto? " + prestamo1.estaDevuelto());
        System.out.println("Estado del libro: " + libroFisico.getEstado());
        System.out.println("¿Libro disponible? " + libroFisico.estaDisponible());

        // =====================================================
        // 9. MOSTRAR LA RELACIÓN AUTOR -> LIBRO
        // =====================================================
        System.out.println("\n--- LIBROS DE LOS AUTORES ---");
        for (Libro libro : autor1.getLibros()) {
            System.out.println("Autor: " + autor1.getNombre() + " -> " + libro.getTitulo());
        }

        for (Libro libro : autor2.getLibros()) {
            System.out.println("Autor: " + autor2.getNombre() + " -> " + libro.getTitulo());
        }

        // =====================================================
        // 10. COMPROBACIÓN FINAL
        // =====================================================
        System.out.println("\n--- ESTADO FINAL ---");
        System.out.println("Libro físico: " + libroFisico.getEstado());
        System.out.println("Libro digital: " + libroDigital.getEstado());

        // El enum se importa y se puede utilizar directamente.
        if (libroDigital.getEstado() == EstadoDisponibilidad.DISPONIBLE) {
            System.out.println("El libro digital está disponible.");
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}