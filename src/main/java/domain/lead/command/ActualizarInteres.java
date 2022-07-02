package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.values.Interes;
import domain.lead.values.LeadID;

public class ActualizarInteres extends Command {
    private final LeadID leadID;
    private final Interes interes;

    public ActualizarInteres(LeadID leadID, Interes interes) {
        this.leadID = leadID;
        this.interes = interes;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public Interes Interes() {
        return interes;
    }
}
