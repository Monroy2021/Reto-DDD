package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.Conyugue;
import domain.cliente.values.ProspectoID;

public class conyugueProspectoActualizada extends DomainEvent {

    private final ProspectoID prospectoID;
    private final Conyugue conyugue;
    public conyugueProspectoActualizada(ProspectoID prospectoID, Conyugue conyugue) {
        super("YourCallCenterDDD.domain.cliente.event.conyugueProspectoActualizada");
        this.prospectoID=prospectoID;
        this.conyugue=conyugue;
    }

    public ProspectoID ProspectoID() {
        return prospectoID;
    }

    public Conyugue Conyugue() {
        return conyugue;
    }
}
