package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.AsistenteID;
import domain.cliente.values.ClienteLlamadaID;
import domain.cliente.values.LlamadaID;
import domain.cliente.values.NombreAsistente;

public class ActualizarNombreAsistente extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final AsistenteID asistenteID;
    private final NombreAsistente nombreAsistente;

    public ActualizarNombreAsistente(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, AsistenteID asistenteID, NombreAsistente nombreAsistente) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.asistenteID = asistenteID;
        this.nombreAsistente = nombreAsistente;
    }

    public ClienteLlamadaID ClienteLlamadaID() {
        return clienteLlamadaID;
    }

    public LlamadaID LlamadaID() {
        return llamadaID;
    }

    public AsistenteID AsistenteID() {
        return asistenteID;
    }

    public NombreAsistente NombreAsistente() {
        return nombreAsistente;
    }
}
