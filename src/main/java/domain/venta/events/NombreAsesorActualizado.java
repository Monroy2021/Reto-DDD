package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.AsesorID;
import domain.venta.values.Nombre;

public class NombreAsesorActualizado  extends DomainEvent {
    private final AsesorID asesorID;
    private final Nombre nombre;

    public NombreAsesorActualizado(AsesorID asesorID, Nombre nombre) {
        super("domain.venta.events.NombreAsesorActualizado");
        this.asesorID=asesorID;
        this.nombre=nombre;
    }

    public AsesorID AsesorID() {
        return asesorID;
    }


    public Nombre Nombre() {
        return nombre;
    }
}
