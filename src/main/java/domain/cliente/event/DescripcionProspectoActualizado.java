package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.DescripcionProspecto;
import domain.cliente.values.ProspectoID;

public class DescripcionProspectoActualizado extends DomainEvent {
    private final ProspectoID prospectoID;
    private final DescripcionProspecto descripcionProspecto;

    public DescripcionProspectoActualizado(ProspectoID prospectoID, DescripcionProspecto descripcionProspecto) {
        super("domain.cliente.event.DescripcionProspectoActualizado");
        this.prospectoID=prospectoID;
        this.descripcionProspecto=descripcionProspecto;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public DescripcionProspecto DescripcionProspecto() {
        return descripcionProspecto;
    }
}
