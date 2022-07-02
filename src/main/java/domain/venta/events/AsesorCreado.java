package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;

public class AsesorCreado extends DomainEvent {
    private final AsesorID id;
    private final Nombre nombre;
    public AsesorCreado(AsesorID id, Nombre nombre) {
        super("domain.venta.events.AsesorCreado");
        this.id=id;
        this.nombre=nombre;
    }

    public AsesorID Id() {
        return id;
    }

    public Nombre Nombre() {
        return nombre;
    }
}
