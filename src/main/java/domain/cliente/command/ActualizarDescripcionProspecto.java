package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.DescripcionProspecto;
import domain.cliente.values.LlamadaID;
import domain.cliente.values.ProspectoID;

public class ActualizarDescripcionProspecto extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final ProspectoID prospectoID;
    private final DescripcionProspecto descripcionProspecto;

    public ActualizarDescripcionProspecto(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, ProspectoID prospectoID, DescripcionProspecto descripcionProspecto) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.prospectoID = prospectoID;
        this.descripcionProspecto=descripcionProspecto;
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

    public DescripcionProspecto DescripcionProspecto() {
        return descripcionProspecto;
    }
}
