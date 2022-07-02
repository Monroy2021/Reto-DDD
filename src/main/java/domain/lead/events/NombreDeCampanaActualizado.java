package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.values.CampanaID;
import domain.lead.values.NombreCampana;

public class NombreDeCampanaActualizado extends DomainEvent {
    private final CampanaID campanaID;
    private final NombreCampana nombre;

    public NombreDeCampanaActualizado(CampanaID campanaID, NombreCampana nombre) {
        super("YourCallCenterDDD.domain.lead.events.NombreDeCampanaActualizado");
        this.campanaID=campanaID;
        this.nombre=nombre;
    }

    public CampanaID CampanaID() {
        return campanaID;
    }

    public NombreCampana Nombre() {
        return nombre;
    }
}
