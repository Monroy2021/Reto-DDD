package domain.cliente;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.values.*;

import java.util.Objects;

public class Prospecto extends Entity<ProspectoID> {

    private DescripcionProspecto descripcion;
    private Cita cita;
    private TipoFinaciamiento tipoFinaciamiento;
    private Renta renta;
    private Conyugue conyugue;

    public Prospecto(ProspectoID entityId, DescripcionProspecto descripcion, Cita cita, TipoFinaciamiento tipoFinaciamiento, Renta renta, Conyugue conyugue) {
        super(entityId);
        this.descripcion = Objects.requireNonNull(descripcion);
        this.cita = Objects.requireNonNull(cita);
        this.tipoFinaciamiento = Objects.requireNonNull(tipoFinaciamiento);
        this.renta = Objects.requireNonNull(renta);
        this.conyugue = Objects.requireNonNull(conyugue);
    }

    public DescripcionProspecto Descripcion() {
        return descripcion;
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

    public void actualizarDescripcion(DescripcionProspecto descripcion){
        this.descripcion = descripcion;
    }

    public void actualizarCita(Cita cita){
        this.cita=cita;
    }

    public void actualizarTipoFinanciamiento(TipoFinaciamiento tipoFinaciamiento){
        this.tipoFinaciamiento=tipoFinaciamiento;
    }

    public void actualizarRenta(Renta renta){
        this.renta=renta;
    }

    public void actualizarConyugue(Conyugue conyugue){
        this.conyugue=conyugue;
    }
}
