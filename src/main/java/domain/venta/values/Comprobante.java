package domain.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Comprobante implements ValueObject<Comprobante.Properties> {
    private final String descripcion;
    private final String tipoComprobante;

    public Comprobante(String descripcion, String tipoComprobante) {
        this.descripcion = Objects.requireNonNull(descripcion);
        this.tipoComprobante = Objects.requireNonNull(tipoComprobante);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comprobante)) return false;
        Comprobante that = (Comprobante) o;
        return Objects.equals(descripcion, that.descripcion) && Objects.equals(tipoComprobante, that.tipoComprobante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, tipoComprobante);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String descripcion() {
                return descripcion;
            }

            @Override
            public String tipoComprobante() {
                return tipoComprobante;
            }
        };
    }


    public interface Properties{
        String descripcion();
        String tipoComprobante();
    }
}
