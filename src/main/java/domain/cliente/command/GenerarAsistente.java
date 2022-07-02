package domain.cliente.command;

import co.com.sofka.domain.generic.Command;
import domain.cliente.values.*;

public class GenerarAsistente extends Command {
    private final ClienteLlamadaID clienteLlamadaID;
    private final LlamadaID llamadaID;
    private final AsistenteID asistenteID;
    private final Email email;
    private final NombreAsistente nombreAsistente;

    public GenerarAsistente(ClienteLlamadaID clienteLlamadaID, LlamadaID llamadaID, AsistenteID asistenteID, Email email, NombreAsistente nombreAsistente) {
        this.clienteLlamadaID = clienteLlamadaID;
        this.llamadaID = llamadaID;
        this.asistenteID = asistenteID;
        this.email = email;
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

    public Email Email() {
        return email;
    }

    public NombreAsistente NombreAsistente() {
        return nombreAsistente;
    }
}
