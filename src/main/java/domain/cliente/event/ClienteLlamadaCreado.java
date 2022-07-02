package domain.cliente.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cliente.Llamada;
import domain.cliente.values.ClienteLlamadaID;

public class ClienteLlamadaCreado extends DomainEvent {

    private final ClienteLlamadaID clienteID;
    private final Llamada llamada;

    public ClienteLlamadaCreado(ClienteLlamadaID clienteID, Llamada llamada) {
        super("domain.cliente.event.ClienteLlamadaCreado");
        this.clienteID=clienteID;
        this.llamada=llamada;
    }

    public ClienteLlamadaID ClienteID() {
        return clienteID;
    }

    public Llamada Llamada() {
        return llamada;
    }
}
