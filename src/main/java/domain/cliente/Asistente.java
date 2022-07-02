package domain.cliente;

import co.com.sofka.domain.generic.Entity;
import domain.cliente.values.AsistenteID;
import domain.cliente.values.Email;
import domain.cliente.values.NombreAsistente;

import java.util.Objects;

public class Asistente extends Entity<AsistenteID> {
    private Email email;
    private NombreAsistente nombre;

    public Asistente(AsistenteID entityId, Email email, NombreAsistente nombre) {
        super(entityId);
        this.email = Objects.requireNonNull(email);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Email Email() {
        return email;
    }

    public NombreAsistente Nombre() {
        return nombre;
    }

    public void actualizarEmail(Email email){
        this.email=email;
    }

    public void actualizarNombre(NombreAsistente nombre){
        this.nombre=nombre;
    }
}
