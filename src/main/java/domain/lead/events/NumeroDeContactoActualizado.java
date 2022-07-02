package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.values.LeadID;
import domain.lead.values.NumeroDeContacto;

public class NumeroDeContactoActualizado extends DomainEvent {
    private final LeadID leadID;
    private final NumeroDeContacto numeroDeContacto;

    public NumeroDeContactoActualizado(LeadID leadID, NumeroDeContacto numeroDeContacto) {
        super("YourCallCenterDDD.domain.lead.events.NombreDeCampanaActualizado");
        this.leadID=leadID;
        this.numeroDeContacto=numeroDeContacto;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public NumeroDeContacto NumeroDeContacto() {
        return numeroDeContacto;
    }
}
