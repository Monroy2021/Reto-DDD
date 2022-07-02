package domain.lead.command;

import co.com.sofka.domain.generic.Command;
import domain.lead.values.LeadID;
import domain.lead.values.NumeroDeContacto;

public class ActualizarNumeroDeContacto extends Command {
    private final LeadID leadID;
    private final NumeroDeContacto numeroDeContacto;

    public ActualizarNumeroDeContacto(LeadID leadID, NumeroDeContacto numeroDeContacto) {
        this.leadID = leadID;
        this.numeroDeContacto = numeroDeContacto;
    }

    public LeadID LeadID() {
        return leadID;
    }

    public NumeroDeContacto NumeroDeContacto() {
        return numeroDeContacto;
    }
}
