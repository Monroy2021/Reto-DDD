package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.Campana;
import domain.lead.values.Interes;
import domain.lead.values.NumeroDeContacto;
import domain.lead.values.Ubicacion;

public class LeadCreado extends DomainEvent {
    private final Campana campana;
    private final Interes interes;
    private final NumeroDeContacto numeroDeContacto;
    private final Ubicacion ubicacion;

    public LeadCreado(Campana campana, Interes interes, NumeroDeContacto numeroDeContacto, Ubicacion ubicacion) {
        super("YourCallCenterDDD.domain.lead.events.LeadCreado");
        this.campana=campana;
        this.interes=interes;
        this.numeroDeContacto=numeroDeContacto;
        this.ubicacion=ubicacion;
    }

    public Campana Campana() {
        return campana;
    }

    public Interes Interes() {
        return interes;
    }

    public NumeroDeContacto NumeroDeContacto() {
        return numeroDeContacto;
    }

    public Ubicacion Ubicacion() {
        return ubicacion;
    }
}
