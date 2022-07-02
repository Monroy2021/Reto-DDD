package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.ClienteID;
import domain.venta.values.Nombre;

public class NombreClienteActualizado  extends DomainEvent {
    private final ClienteID id;
    private final Nombre nombre;

    public NombreClienteActualizado(ClienteID id, Nombre nombre) {
        super("domain.venta.events.NombreClienteActualizado");
        this.id= id;
        this.nombre=nombre;
    }

    public ClienteID Id() {
        return id;
    }

    public Nombre Nombre() {
        return nombre;
    }

}
