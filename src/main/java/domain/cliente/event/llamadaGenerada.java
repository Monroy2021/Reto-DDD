package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Asistente;
import domain.cliente.Prospecto;
import domain.cliente.values.LlamadaID;

public class llamadaGenerada extends DomainEvent {
    private final LlamadaID llamadaid;
    private final Prospecto prospecto;
    private final Asistente asistente;

    public llamadaGenerada(LlamadaID llamadaid, Prospecto prospecto, Asistente asistente) {
        super("domain.cliente.event.asistenteGenerado");
        this.llamadaid=llamadaid;
        this.prospecto=prospecto;
        this.asistente=asistente;
    }

    public LlamadaID Llamadaid() {
        return llamadaid;
    }

    public Prospecto Prospecto() {
        return prospecto;
    }

    public Asistente Asistente() {
        return asistente;
    }
}
