package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.Cita;
import domain.cliente.values.ProspectoID;

public class CitaProspectoActualizada extends DomainEvent {
    private final ProspectoID prospectoID;
    private final Cita cita;

    public CitaProspectoActualizada(ProspectoID prospectoID, Cita cita) {
        super("domain.cliente.event.CitaProspectoActualizada");
        this.prospectoID=prospectoID;
        this.cita=cita;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public Cita Cita() {
        return cita;
    }
}
