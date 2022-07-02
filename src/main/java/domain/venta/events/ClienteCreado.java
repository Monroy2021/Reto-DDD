package domain.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.venta.values.*;

public class ClienteCreado extends DomainEvent {
    private final ClienteID id;
    private final Identificacion identificacion;
    private final Comprobante comprobante;
    private final NumeroContacto numero;
    private final Deposito deposito;

    public ClienteCreado(ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Deposito deposito) {
        super("domain.venta.events.ClienteCreado");
        this.id=id;
        this.identificacion=identificacion;
        this.comprobante=comprobante;
        this.numero=numero;
        this.deposito=deposito;
    }

    public ClienteID Id() {
        return id;
    }

    public Identificacion Identificacion() {
        return identificacion;
    }

    public Comprobante Comprobante() {
        return comprobante;
    }

    public NumeroContacto Numero() {
        return numero;
    }

    public Deposito Downpayment() {
        return deposito;
    }
}
