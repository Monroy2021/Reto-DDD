package domain.lead.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumeroDeContacto implements ValueObject<String> {
    private final String value;

    public NumeroDeContacto(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof NumeroDeContacto)) return false;
        NumeroDeContacto that = (NumeroDeContacto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
