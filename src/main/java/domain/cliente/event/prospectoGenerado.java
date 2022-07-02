package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.values.*;

public class prospectoGenerado extends DomainEvent {
    private final ProspectoID prospectoid;
    private final DescripcionProspecto descripcionProspecto;
    private final Cita cita;
    private final TipoFinaciamiento tipoFinaciamiento;
    private final Renta renta;
    private final Conyugue conyugue;

    public prospectoGenerado(ProspectoID prospectoid, DescripcionProspecto descripcionProspecto, Cita cita, TipoFinaciamiento tipoFinaciamiento, Renta renta, Conyugue conyugue) {
        super("domain.cliente.event.asistenteGenerado");
        this.prospectoid=prospectoid;
        this.descripcionProspecto=descripcionProspecto;
        this.cita=cita;
        this.tipoFinaciamiento=tipoFinaciamiento;
        this.renta=renta;
        this.conyugue=conyugue;
    }

    public ProspectoID Prospectoid() {
        return prospectoid;
    }

    public DescripcionProspecto DescripcionProspecto() {
        return descripcionProspecto;
    }

    public Cita Cita() {
        return cita;
    }

    public TipoFinaciamiento TipoFinaciamiento() {
        return tipoFinaciamiento;
    }

    public Renta Renta() {
        return renta;
    }

    public Conyugue Conyugue() {
        return conyugue;
    }
}
