package domain.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumeroContacto implements ValueObject<String> {
    private final String value;

    public NumeroContacto(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumeroContacto)) return false;
        NumeroContacto that = (NumeroContacto) o;
        return Objects.equals(value, that.value);
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
