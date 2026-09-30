package smartlibrary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prestamo {
    private Estudiante estudiante;
    private Ejemplar ejemplar;
    private LocalDate fechaPrevistaDevolucion;
    private List<Renovacion> renovaciones = new ArrayList<>();

    public Prestamo(Estudiante estudiante, Ejemplar ejemplar, LocalDate fechaPrevistaDevolucion) {
        this.estudiante = estudiante;
        this.ejemplar = ejemplar;
        this.fechaPrevistaDevolucion = fechaPrevistaDevolucion;
    }

    public void renovar(LocalDate nuevaFecha) {
        if (!nuevaFecha.isAfter(this.fechaPrevistaDevolucion)) {
            throw new IllegalArgumentException(
                "La nueva fecha (" + nuevaFecha + ") debe ser posterior a la fecha prevista actual (" + this.fechaPrevistaDevolucion + ")."
            );
        }

        LocalDate fechaAnterior = this.fechaPrevistaDevolucion;
        Renovacion renovacion = new Renovacion(LocalDate.now(), fechaAnterior, nuevaFecha);
        
        this.renovaciones.add(renovacion);
        this.fechaPrevistaDevolucion = nuevaFecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public LocalDate getFechaPrevistaDevolucion() {
        return fechaPrevistaDevolucion;
    }

    public List<Renovacion> getRenovaciones() {
        return Collections.unmodifiableList(renovaciones);
    }
}
