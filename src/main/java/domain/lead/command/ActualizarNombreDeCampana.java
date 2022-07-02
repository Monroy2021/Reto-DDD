package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.values.CampanaID;
import domain.lead.values.LeadID;
import domain.lead.values.NombreCampana;

public class ActualizarNombreDeCampana extends Command {
    private final LeadID leadID;
    private final CampanaID campanaID;
    private final NombreCampana nombre;

    public ActualizarNombreDeCampana(LeadID leadID,CampanaID campanaID, NombreCampana nombre) {
        this.leadID=leadID;
        this.campanaID = campanaID;
        this.nombre = nombre;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public CampanaID CampanaID() {
        return campanaID;
    }

    public NombreCampana Nombre() {
        return nombre;
    }
}
