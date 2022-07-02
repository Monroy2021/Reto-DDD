package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.values.CampanaID;
import domain.lead.values.FechaDeContacto;
import domain.lead.values.LeadID;
import domain.lead.values.NombreCampana;

public class CrearCampana extends Command {

    private final LeadID leadID;
    private final CampanaID campanaID;
    private final NombreCampana nombreCampana;
    private final FechaDeContacto fechaDeContacto;

    public CrearCampana(LeadID leadID, CampanaID campanaID, NombreCampana nombreCampana, FechaDeContacto fechaDeContacto) {
        this.leadID = leadID;
        this.campanaID = campanaID;
        this.nombreCampana = nombreCampana;
        this.fechaDeContacto = fechaDeContacto;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public CampanaID CampanaID() {
        return campanaID;
    }

    public NombreCampana NombreCampana() {
        return nombreCampana;
    }

    public FechaDeContacto FechaDeContacto() {
        return fechaDeContacto;
    }
}
