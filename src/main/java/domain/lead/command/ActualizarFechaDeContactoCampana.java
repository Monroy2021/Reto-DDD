package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.values.CampanaID;
import domain.lead.values.FechaDeContacto;
import domain.lead.values.LeadID;

public class ActualizarFechaDeContactoCampana extends Command {
    private final LeadID leadID;
    private final CampanaID campanaID;
    private final FechaDeContacto fechaDeContacto;

    public ActualizarFechaDeContactoCampana(LeadID leadID, CampanaID campanaID, FechaDeContacto fechaDeContacto) {
        this.leadID = leadID;
        this.campanaID = campanaID;
        this.fechaDeContacto = fechaDeContacto;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public CampanaID CampanaID() {
        return campanaID;
    }

    public FechaDeContacto FechaDeContacto() {
        return fechaDeContacto;
    }
}
