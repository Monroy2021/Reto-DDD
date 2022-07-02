package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.AsistenteID;
import domain.cliente.values.Email;
import domain.cliente.values.NombreAsistente;

public class asistenteGenerado extends DomainEvent {
    private final AsistenteID asistenteID;
    private final Email email;
    private final NombreAsistente nombreAsistente;

    public asistenteGenerado(AsistenteID asistenteID, Email email, NombreAsistente nombreAsistente) {
        super("domain.cliente.event.asistenteGenerado");
        this.asistenteID=asistenteID;
        this.email=email;
        this.nombreAsistente=nombreAsistente;
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
