package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.AsistenteID;
import domain.cliente.values.Email;

public class EmailAsistenteActualizado extends DomainEvent {

    private final AsistenteID asistenteID;
    private final Email email;
    public EmailAsistenteActualizado(AsistenteID asistenteID, Email email) {
        super("domain.cliente.event.EmailAsistenteActualizado");
        this.asistenteID=asistenteID;
        this.email=email;
    }

    public AsistenteID AsistenteID() {
        return asistenteID;
    }

    public Email Email() {
        return email;
    }
}
