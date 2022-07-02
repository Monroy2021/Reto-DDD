package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.ClienteID;
import domain.venta.values.NumeroContacto;

public class NumeroContactoClienteActualizado extends DomainEvent {
    private final ClienteID clienteID;

    private final NumeroContacto numero;

    public NumeroContactoClienteActualizado(ClienteID clienteID, NumeroContacto numero) {
        super("domain.venta.events.NumeroContactoClienteActualizado");
        this.clienteID=clienteID;
        this.numero=numero;
    }

    public ClienteID ClienteID() {
        return clienteID;
    }

    public NumeroContacto Numero() {
        return numero;
    }

}
