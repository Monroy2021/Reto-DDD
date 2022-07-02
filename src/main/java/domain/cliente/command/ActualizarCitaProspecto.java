package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.Cita;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.LlamadaID;
import domain.cliente.values.ProspectoID;

public class ActualizarCitaProspecto extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final Cita cita;

    public ActualizarCitaProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, Cita cita) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.cita = cita;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public LlamadaID LlamadaID() {
        return llamadaID;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public Cita Cita() {
        return cita;
    }
}
