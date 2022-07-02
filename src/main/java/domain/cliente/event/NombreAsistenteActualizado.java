package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.AsistenteID;
import domain.cliente.values.NombreAsistente;

public class NombreAsistenteActualizado extends DomainEvent {
    private final AsistenteID asistenteID;
    private final NombreAsistente nombreAsistente;

    public NombreAsistenteActualizado(AsistenteID asistenteID, NombreAsistente nombreAsistente) {
        super("domain.cliente.event.asistenteGenerado");
        this.asistenteID=asistenteID;
        this.nombreAsistente=nombreAsistente;
    }

    public AsistenteID getAsistenteID() {
        return asistenteID;
    }

    public NombreAsistente getNombreAsistente() {
        return nombreAsistente;
    }
}
