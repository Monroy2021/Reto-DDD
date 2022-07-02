package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.Campana;
import domain.lead.values.Interes;
import domain.lead.values.LeadID;
import domain.lead.values.NumeroDeContacto;
import domain.lead.values.Ubicacion;

public class CrearLead extends Command {
    private final LeadID leadID;
    private final Campana campana;
    private final Interes interes;
    private final NumeroDeContacto numeroDeContacto;
    private final Ubicacion ubicacion;

    public CrearLead(LeadID leadID, Campana campana, Interes interes, NumeroDeContacto numeroDeContacto, Ubicacion ubicacion) {
        this.leadID = leadID;
        this.campana = campana;
        this.interes = interes;
        this.numeroDeContacto = numeroDeContacto;
        this.ubicacion = ubicacion;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public Campana Campana() {
        return campana;
    }

    public Interes Interes() {
        return interes;
    }

    public NumeroDeContacto NumeroDeContacto() {
        return numeroDeContacto;
    }

    public Ubicacion Ubicacion() {
        return ubicacion;
    }
}
