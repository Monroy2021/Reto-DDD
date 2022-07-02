package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Renta implements ValueObject<Renta.Properties> {
    private final Boolean activa;
    private final Double valor;

    public Renta(Boolean activa, Double valor) {
        this.activa = Objects.requireNonNull(activa);
        this.valor = Objects.requireNonNull(valor);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Boolean activa() {
                return activa;
            }

            @Override
            public Double valor() {
                return valor;
            }
        };
    }

    public interface Properties{
        Boolean activa();
        Double valor();
    }
}
