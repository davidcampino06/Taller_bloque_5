package smartlibrary;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("1085123456", "Carlos", "carlos@mail.com", "EST-2026", "Ingeniería de Software");
        Ejemplar ejemplar = new Ejemplar("EJP-001", "Prestado");
        
        LocalDate fechaInicialDevolucion = LocalDate.of(2026, 10, 1);
        Prestamo prestamo = new Prestamo(estudiante, ejemplar, fechaInicialDevolucion);

        System.out.println("=== PRUEBA 1: Renovación Válida ===");
        LocalDate nuevaFechaValida = LocalDate.of(2026, 10, 15);
        
        prestamo.renovar(nuevaFechaValida);
        estudiante.notificar("Su préstamo fue renovado exitosamente.");

        System.out.println("Nueva fecha de devolución: " + prestamo.getFechaPrevistaDevolucion());
        System.out.println("Cantidad de renovaciones realizadas: " + prestamo.getRenovaciones().size());

        System.out.println("\n=== PRUEBA 2: Renovación Inválida ===");
        try {
            LocalDate nuevaFechaInvalida = LocalDate.of(2026, 10, 10); // Anterior a la prevista vigente (15-Oct)
            prestamo.renovar(nuevaFechaInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
        }
    }
}
