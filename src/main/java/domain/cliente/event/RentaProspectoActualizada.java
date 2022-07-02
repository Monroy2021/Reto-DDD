package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.ProspectoID;
import domain.cliente.values.Renta;

public class RentaProspectoActualizada extends DomainEvent {
    private final ProspectoID prospectoID;
    private final Renta renta;

    public RentaProspectoActualizada(ProspectoID prospectoID, Renta renta) {
        super("YourCallCenterDDD.domain.cliente.event.asistenteGenerado");
        this.prospectoID=prospectoID;
        this.renta=renta;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public Renta Renta() {
        return renta;
    }
}
