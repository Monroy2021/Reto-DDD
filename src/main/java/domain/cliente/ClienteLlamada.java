package domain.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.event.*;
import domain.cliente.values.*;

import java.util.List;
import java.util.Objects;

public class ClienteLlamada extends AggregateEvent<ClienteLlamadaID> {

    protected Llamada llamada;

    public ClienteLlamada(ClienteLlamadaID entityId, Llamada llamada) {
        super(entityId);
        Objects.requireNonNull(llamada);
        subscribe(new ClienteLlamadaChange(this));
        appendChange(new ClienteLlamadaCreado(entityId, llamada)).apply();
    }

    public static ClienteLlamada from(ClienteLlamadaID clienteID, List<DomainEvent> events){
        ClienteLlamada cliente = new ClienteLlamada(clienteID);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public ClienteLlamada(ClienteLlamadaID clienteID){
        super(clienteID);
        subscribe(new ClienteLlamadaChange(this));
    }

    public Llamada Llamada() {
        return llamada;
    }

    public void actualizarNombreAsistente(AsistenteID asistenteID, NombreAsistente nombreAsistente){
        Objects.requireNonNull(asistenteID);
        Objects.requireNonNull(nombreAsistente);
        appendChange(new NombreAsistenteActualizado(asistenteID, nombreAsistente)).apply();
    }
    public void actualizarEmailAsistente(AsistenteID asistenteID, Email email){
        Objects.requireNonNull(asistenteID);
        Objects.requireNonNull(email);
        appendChange(new EmailAsistenteActualizado(asistenteID, email)).apply();
    }

    public void actualizarDescripcionProspecto(ProspectoID prospectoID, DescripcionProspecto descripcionProspecto){
        Objects.requireNonNull(prospectoID);
        Objects.requireNonNull(descripcionProspecto);
        appendChange(new DescripcionProspectoActualizado(prospectoID, descripcionProspecto)).apply();
    }

    public void actualizarCitaProspecto(ProspectoID prospectoID, Cita cita){
        Objects.requireNonNull(prospectoID);
        Objects.requireNonNull(cita);
        appendChange(new CitaProspectoActualizada(prospectoID, cita)).apply();;
    }

    public void actualizarTipoFinanciamientoProspecto(ProspectoID prospectoID, TipoFinaciamiento tipoFinaciamiento){
        Objects.requireNonNull(prospectoID);
        Objects.requireNonNull(tipoFinaciamiento);
        appendChange(new TipoFinanciamientoProspectoActualizado(prospectoID, tipoFinaciamiento)).apply();
    }

    public void actualizarRentaProspecto(ProspectoID prospectoID, Renta renta){
        Objects.requireNonNull(prospectoID);
        Objects.requireNonNull(renta);
        appendChange(new RentaProspectoActualizada(prospectoID, renta)).apply();
    }
    public void actualizarConyugueProspecto(ProspectoID prospectoID, Conyugue conyugue){
        Objects.requireNonNull(prospectoID);
        Objects.requireNonNull(conyugue);
        appendChange(new conyugueProspectoActualizada(prospectoID, conyugue)).apply();
    }

    public void generarLlamada(LlamadaID llamada, Prospecto prospecto, Asistente asistente){
        Objects.requireNonNull(llamada);
        Objects.requireNonNull(prospecto);
        Objects.requireNonNull(asistente);
        appendChange(new llamadaGenerada(llamada,prospecto, asistente)).apply();
    }

    public void generarProspecto(ProspectoID prospectoid, DescripcionProspecto descripcionProspecto, Cita cita, TipoFinaciamiento tipoFinaciamiento, Renta renta, Conyugue conyugue){
        Objects.requireNonNull(prospectoid);
        Objects.requireNonNull(descripcionProspecto);
        Objects.requireNonNull(cita);
        Objects.requireNonNull(tipoFinaciamiento);
        Objects.requireNonNull(renta);
        Objects.requireNonNull(conyugue);
        appendChange(new prospectoGenerado(prospectoid, descripcionProspecto, cita, tipoFinaciamiento, renta, conyugue)).apply();
    }

    public void generarAsistente(AsistenteID asistenteID, Email email, NombreAsistente nombreAsistente){
        Objects.requireNonNull(asistenteID);
        Objects.requireNonNull(email);
        Objects.requireNonNull(nombreAsistente);
        appendChange(new asistenteGenerado(asistenteID, email, nombreAsistente)).apply();
    }


}
