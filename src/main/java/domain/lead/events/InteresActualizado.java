package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.values.Interes;
import domain.lead.values.LeadID;

public class InteresActualizado extends DomainEvent {
    private final LeadID leadID;
    private final Interes interes;

    public InteresActualizado(LeadID leadID, Interes interes) {
        super("YourCallCenterDDD.domain.lead.events.InteresActualizado");
        this.leadID=leadID;
        this.interes=interes;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public Interes Interes() {
        return interes;
    }
}
