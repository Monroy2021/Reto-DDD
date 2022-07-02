package domain.lead.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.values.CampanaID;
import domain.lead.values.FechaDeContacto;
import domain.lead.values.NombreCampana;

public class CampanaCreada extends DomainEvent {
    private final CampanaID campanaID;
    private final NombreCampana nombreCampana;
    private final FechaDeContacto fechaDeContacto;

    public CampanaCreada(CampanaID campanaID, NombreCampana nombreCampana, FechaDeContacto fechaDeContacto){
        super("YourCallCenterDDD.domain.lead.CampanaCreada");
        this.campanaID=campanaID;
        this.nombreCampana=nombreCampana;
        this.fechaDeContacto=fechaDeContacto;
    }

    public CampanaID CampanaID() {
        return campanaID;
    }

    public NombreCampana NombreCampana() {
        return nombreCampana;
    }

    public FechaDeContacto FechaDeContacto() {
        return fechaDeContacto;
    }
}
