package domain.lead.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCampana implements ValueObject<String> {
    private final String value;

    public NombreCampana(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NombreCampana)) return false;
        NombreCampana nombre = (NombreCampana) o;
        return Objects.equals(value, nombre.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
