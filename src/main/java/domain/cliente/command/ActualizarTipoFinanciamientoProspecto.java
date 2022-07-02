package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.LlamadaID;
import domain.cliente.values.ProspectoID;
import domain.cliente.values.TipoFinaciamiento;

public class ActualizarTipoFinanciamientoProspecto extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final TipoFinaciamiento tipoFinaciamiento;

    public ActualizarTipoFinanciamientoProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, TipoFinaciamiento tipoFinaciamiento) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.tipoFinaciamiento = tipoFinaciamiento;
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

    public TipoFinaciamiento TipoFinaciamiento() {
        return tipoFinaciamiento;
    }
}
