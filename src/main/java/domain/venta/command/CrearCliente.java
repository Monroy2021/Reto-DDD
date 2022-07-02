package domain.venta.command;

import co.com.sofka.domain.generic.Command;
import domain.venta.values.*;

public class CrearCliente extends Command {

    private final VentaID idVenta;
    private final ClienteID id;
    private final Identificacion identificacion;
    private final Comprobante comprobante;
    private final NumeroContacto numero;
    private final Deposito deposito;

    public CrearCliente(VentaID idVenta, ClienteID id, Identificacion identificacion, Comprobante comprobante, NumeroContacto numero, Deposito deposito) {
        this.idVenta=idVenta;
        this.id = id;
        this.identificacion = identificacion;
        this.comprobante = comprobante;
        this.numero = numero;
        this.deposito = deposito;
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

    public VentaID IdVenta() {
        return idVenta;
    }

}
