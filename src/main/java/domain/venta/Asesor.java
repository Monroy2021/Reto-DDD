package domain.venta;

import co.com.sofka.domain.generic.Entity;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;

import java.util.Objects;

public class Asesor extends Entity<AsesorID> {
    private Nombre nombre;

    public Asesor(AsesorID entityId, Nombre nombre) {
        super(entityId);
        this.nombre= Objects.requireNonNull(nombre);
    }

    public Nombre Nombre() {
        return nombre;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre=nombre;
    }
}
