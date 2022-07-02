package domain.lead.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FechaDeContacto implements ValueObject<String> {
    private final String value;

    public FechaDeContacto(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FechaDeContacto)) return false;
        FechaDeContacto that = (FechaDeContacto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
