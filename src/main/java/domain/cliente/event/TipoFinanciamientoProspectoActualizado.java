package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.ProspectoID;
import domain.cliente.values.TipoFinaciamiento;

public class TipoFinanciamientoProspectoActualizado extends DomainEvent {
    private final ProspectoID prospectoID;
    private final TipoFinaciamiento tipoFinaciamiento;
    public TipoFinanciamientoProspectoActualizado(ProspectoID prospectoID, TipoFinaciamiento tipoFinaciamiento) {
        super("YourCallCenterDDD.domain.cliente.event.asistenteGenerado");
        this.prospectoID=prospectoID;
        this.tipoFinaciamiento=tipoFinaciamiento;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public TipoFinaciamiento TipoFinaciamiento() {
        return tipoFinaciamiento;
    }
}
