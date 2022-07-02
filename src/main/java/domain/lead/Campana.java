package domain.lead;

import co.com.sofka.domain.generic.Entity;
import domain.lead.values.CampanaID;
import domain.lead.values.FechaDeContacto;
import domain.lead.values.NombreCampana;

import java.util.Objects;

public class Campana extends Entity<CampanaID> {

    private NombreCampana nombre;
    private FechaDeContacto fechaDeContacto;

    public Campana(CampanaID entityId, NombreCampana nombre, FechaDeContacto fechaDeContacto) {
        super(entityId);
        this.nombre = Objects.requireNonNull(nombre);
        this.fechaDeContacto = Objects.requireNonNull(fechaDeContacto);
    }

    public NombreCampana Nombre() {
        return nombre;
    }

    public FechaDeContacto FechaDeContacto() {
        return fechaDeContacto;
    }

    public void actualizarNombre(NombreCampana nombre){
        this.nombre=nombre;
    }

    public void actualizarFechaDeContacto(FechaDeContacto fechaDeContacto){
        this.fechaDeContacto= fechaDeContacto;
    }
}
