package domain.lead;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.lead.events.*;
import domain.lead.values.*;

import java.util.List;
import java.util.Objects;

public class Lead extends AggregateEvent<LeadID> {
    protected Campana campana;
    protected Interes interes;
    protected NumeroDeContacto numeroDeContacto;
    protected Ubicacion ubicacion;

    public Lead(LeadID entityId, Campana campana, Interes interes, NumeroDeContacto numeroDeContacto, Ubicacion ubicacion) {
        super(entityId);
        Objects.requireNonNull(entityId);Objects.requireNonNull(campana);
        Objects.requireNonNull(interes);
        Objects.requireNonNull(numeroDeContacto);
        Objects.requireNonNull(ubicacion);
        subscribe(new LeadChange(this));
        appendChange(new LeadCreado(campana, interes, numeroDeContacto, ubicacion)).apply();
    }

    public static Lead from(LeadID leadID, List<DomainEvent> events){
        Lead lead = new Lead(leadID);
        events.forEach(lead::applyEvent);
        return lead;
    }

    public Lead(LeadID id){
        super(id);
        subscribe(new LeadChange(this));
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


    public void actualizarInteres(LeadID leadID, Interes interes){
        Objects.requireNonNull(leadID);
        Objects.requireNonNull(interes);
        appendChange(new InteresActualizado(leadID, interes)).apply();
    }

    public void actualizarNumeroContacto(LeadID leadID, NumeroDeContacto numeroDeContacto){
        Objects.requireNonNull(leadID);
        Objects.requireNonNull(numeroDeContacto);
        appendChange(new NumeroDeContactoActualizado(leadID, numeroDeContacto)).apply();
    }

    public void actualizarNombreDeCampana(CampanaID campanaID, NombreCampana nombre){
        Objects.requireNonNull(campanaID);
        Objects.requireNonNull(nombre);
        appendChange(new NombreDeCampanaActualizado(campanaID, nombre)).apply();
    }

    public void actualizarFechaDeContacto(CampanaID campanaID, FechaDeContacto fechaDeContacto){
        Objects.requireNonNull(campanaID);
        Objects.requireNonNull(fechaDeContacto);
        appendChange(new FechaDeContactoCampanaActualizada(campanaID,fechaDeContacto )).apply();
    }

    public void generarCampana(CampanaID campanaID,  NombreCampana nombre, FechaDeContacto fechaDeContacto){
        Objects.requireNonNull(campanaID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(fechaDeContacto);
        appendChange(new CampanaCreada(campanaID,nombre, fechaDeContacto)).apply();

    }

}
