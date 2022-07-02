package domain.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identificacion implements ValueObject<Identificacion.Properties> {
    private final String value;
    private final String tipoIDDescripcion;

    public Identificacion(String value, String tipoIDDescripcion){
        this.value = Objects.requireNonNull(value);
        this.tipoIDDescripcion= Objects.requireNonNull(tipoIDDescripcion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identificacion)) return false;
        Identificacion that = (Identificacion) o;
        return Objects.equals(value, that.value) && Objects.equals(tipoIDDescripcion, that.tipoIDDescripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, tipoIDDescripcion);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String value() {
                return value;
            }

            @Override
            public String tipoIDDescripcion() {
                return tipoIDDescripcion;
            }
        };
    }

    public interface Properties{
        String value();
        String tipoIDDescripcion();
    }
}
