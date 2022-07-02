package domain.cliente;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.values.*;

import java.util.Objects;

public class Llamada extends Entity<LlamadaID> {
    private Prospecto prospecto;
    private Asistente asistente;

    public Llamada(LlamadaID entityId, Prospecto prospecto, Asistente asistente) {
        super(entityId);
        this.prospecto = Objects.requireNonNull(prospecto);
        this.asistente = Objects.requireNonNull(asistente);
    }

    public Prospecto Prospecto() {
        return prospecto;
    }

    public Asistente Asistente() {
        return asistente;
    }

    public void actualizarnombreAsistente(NombreAsistente nombreAsistente){
        this.asistente.actualizarNombre(nombreAsistente);
    }

    public void actualizarEmailAsistente(Email email){
        this.asistente.actualizarEmail(email);
    }

    public void actualizarDescripcionProspecto(DescripcionProspecto descripcion){
        this.prospecto.actualizarDescripcion(descripcion);
    }

    public void actualizarCitaProspecto(Cita cita){
        this.prospecto.actualizarCita(cita);
    }

    public void actualizarTipoFinanciamientoProspecto(TipoFinaciamiento tipoFinaciamiento){
        this.prospecto.actualizarTipoFinanciamiento(tipoFinaciamiento);
    }

    public void actualizarRentaProspecto(Renta renta){
        this.prospecto.actualizarRenta(renta);
    }

    public void actualizarConyugue(Conyugue conyugue){
        this.prospecto.actualizarConyugue(conyugue);
    }


    public void generarProspecto(ProspectoID prospectoID, DescripcionProspecto descripcionProspecto, Cita cita, TipoFinaciamiento tipoFinaciamiento, Renta renta, Conyugue conyugue){
        this.prospecto = new Prospecto(prospectoID,descripcionProspecto, cita,  tipoFinaciamiento,renta,conyugue);
    }

    public void generarAsistente(AsistenteID asistenteID, Email email, NombreAsistente nombreAsistente){
        this.asistente = new Asistente(asistenteID, email, nombreAsistente);
    }
}
