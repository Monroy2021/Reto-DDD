package domain.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Deposito implements ValueObject<Deposito.Properties> {
    private final Double value;
    private final String typePayment;

    public Deposito(Double value, String typePayment) {
        this.value = Objects.requireNonNull(value);
        this.typePayment = Objects.requireNonNull(typePayment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposito)) return false;
        Deposito that = (Deposito) o;
        return Objects.equals(value, that.value) && Objects.equals(typePayment, that.typePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, typePayment);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Double value() {
                return value;
            }

            @Override
            public String typePayment() {
                return typePayment;
            }
        };
    }


    public interface Properties{
        Double value();
        String typePayment();
    }

}
