package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.values.CampanaID;
import domain.lead.values.FechaDeContacto;

public class FechaDeContactoCampanaActualizada extends DomainEvent {
    private final CampanaID id;
    private final FechaDeContacto fechaDeContacto;

    public FechaDeContactoCampanaActualizada(CampanaID id, FechaDeContacto fechaDeContacto) {
        super("YourCallCenterDDD.domain.lead.events.FechaDeContactoActualizada");
        this.id=id;
        this.fechaDeContacto=fechaDeContacto;
    }

    public CampanaID Id() {
        return id;
    }

    public FechaDeContacto FechaDeContacto() {
        return fechaDeContacto;
    }
}
