package domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionProspecto implements ValueObject<DescripcionProspecto.Properties> {
    private final String RazonDeBusqueda;
    private final String LugarDeBusqueda;

    public DescripcionProspecto(String razonDeBusqueda, String lugarDeBusqueda) {
        RazonDeBusqueda = Objects.requireNonNull(razonDeBusqueda);
        LugarDeBusqueda = Objects.requireNonNull(lugarDeBusqueda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescripcionProspecto)) return false;
        DescripcionProspecto that = (DescripcionProspecto) o;
        return Objects.equals(RazonDeBusqueda, that.RazonDeBusqueda) && Objects.equals(LugarDeBusqueda, that.LugarDeBusqueda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(RazonDeBusqueda, LugarDeBusqueda);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String razonDeBusqueda() {
                return RazonDeBusqueda;
            }

            @Override
            public String LugarDeBusqueda() {
                return LugarDeBusqueda;
            }
        };
    }


    public interface Properties{
        String razonDeBusqueda();
        String LugarDeBusqueda();
    }
}
