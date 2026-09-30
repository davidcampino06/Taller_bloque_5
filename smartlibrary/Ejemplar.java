package smartlibrary;

public class Ejemplar {
    private String codigoBarras;
    private String estado;

    public Ejemplar(String codigoBarras, String estado) {
        this.codigoBarras = codigoBarras;
        this.estado = estado;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
