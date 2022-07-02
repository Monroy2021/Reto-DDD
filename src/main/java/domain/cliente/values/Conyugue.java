package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Conyugue implements ValueObject<Conyugue.Properties> {

    private final Boolean tieneConyugue;
    private final String nombreConyugue;

    public Conyugue(Boolean tieneConyugue, String nombreConyugue) {
        this.tieneConyugue = Objects.requireNonNull(tieneConyugue);
        this.nombreConyugue = Objects.requireNonNull(nombreConyugue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conyugue)) return false;
        Conyugue conyugue = (Conyugue) o;
        return Objects.equals(tieneConyugue, conyugue.tieneConyugue) && Objects.equals(nombreConyugue, conyugue.nombreConyugue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tieneConyugue, nombreConyugue);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Boolean tieneConyugue() {
                return tieneConyugue;
            }

            @Override
            public String nombreConyugue() {
                return nombreConyugue;
            }
        };
    }


    public interface Properties{
        Boolean tieneConyugue();
        String nombreConyugue();
    }
}
