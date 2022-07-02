package domain.lead.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Interes implements ValueObject<String> {
    private final String value;

    public Interes(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interes)) return false;
        Interes interes = (Interes) o;
        return Objects.equals(value, interes.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
